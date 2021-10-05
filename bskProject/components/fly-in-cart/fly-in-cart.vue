<template>
	<view class="container">
		<!-- 加入购物车的小球 -->
		<view class="good_box" v-if="!hide_good_box" :style="'left:'+bus_x+'px;top:'+bus_y+'px;'">
			<image :src="imgUrl"></image>
		</view>
	</view>
</template>
<script>
	import $flyInData from '@/components/fly-in-cart/fly-in-cart.js'
	export default {
		data() {
			return {
				count: 0,
				hide_good_box: true,
				finger: {},
				busPos: {},
				bus_x: 0,
				bus_y: 0,
				imgUrl: '../../static/logo.png',
			}
		},
		props: {
			cartx: { //购物车X坐标 在屏幕中的比例 值 0-1 之间 
				type: String,
				default: '0'
			},
			carty: { //购物车y坐标 在屏幕中的比例 值 0-1 之间
				type: String,
				default: '0'
			},
		},
		created: function() {
			/** 计算购物车的坐标 **/
			var that = this;
			uni.getSystemInfo({
				success: function(res) {
					let ww = res.windowWidth;//取窗口宽度
					let hh = res.windowHeight;//取窗口高度
					
					//此处可能需要根据设备不同 条件编译一下 偏移值
					let devx = 1;//x偏移值
					let devy = 1;//y偏移值
					// #ifdef APP-PLUS
						devx = 1;
						devy = 0.93;
					// #endif
					// #ifdef MP-WEIXIN
						devx = 1;
						devy = 0.9;
					// #endif
					// #ifdef H5
						devx = 1;
						devy = 1;
					// #endif
					
					that.busPos['x'] = ww * that.cartx * devx; //根据屏幕大小*cartx购物车X坐标比例 计算购物车实际x坐标
					that.busPos['y'] = hh * that.carty * devy; //根据屏幕大小*carty购物车y坐标比例 计算购物车实际y坐标
				}
			})
			that.count = 0;
		},
		methods: {
			touchOnGoods: function(e) {
				//this.imgUrl = e.currentTarget.dataset.img;
				// 如果good_box正在运动
				if (!this.hide_good_box) return;
				var topPoint = {};
				this.finger['x'] = e.touches["0"].clientX-13; //取点击位置 x坐标
				this.finger['y'] = e.touches["0"].clientY-10; //取点击位置 y坐标 -10是因为点击位置有些偏移,此数值可根据实际情况自由设置
				if (this.finger['y'] < this.busPos['y']) {
					topPoint['y'] = this.finger['y'] - 150;
				} else {
					topPoint['y'] = this.busPos['y'] - 150;
				}
				topPoint['x'] = Math.abs(this.finger['x'] - this.busPos['x']) / 2;
				/** this.finger['x']是点击位置X坐标  this.busPos['x']是购物车X坐标***/
				if (this.finger['x'] > this.busPos['x']) {
					/* 当点击位置X坐标>购物车X坐标 时 执行 左抛物线 **/
					topPoint['x'] = (this.finger['x'] - this.busPos['x']) / 2 + this.busPos['x'];
					/* 贝塞尔算法 创建从购物车到点击位置的 抛物线  抛物线本身并不分左右*/
					this.linePos = $flyInData.bezier([this.busPos, topPoint, this.finger], 30);
					this.startAnimationLeft(); //逆时针执行抛物线 就形成了 左抛物线
				} else {
					/* 当点击位置X坐标<购物车X坐标 时 执行 右抛物线 **/
					topPoint['x'] = (this.busPos['x'] - this.finger['x']) / 2 + this.finger['x'];
					/* 贝塞尔算法 创建从点击位置到购物车的 抛物线  抛物线本身并不分左右*/
					this.linePos = $flyInData.bezier([this.finger, topPoint, this.busPos], 30);
					this.startAnimationRight(); //顺时针执行抛物线 就形成了 右抛物线
				}
			},
			/* 向右抛物线 根据抛弧线数据 定时器修改good_box style left 和 top 的值来实现动画效果 */
			startAnimationRight: function() {
				var index = 0,
					that = this,
					bezier_points = that.linePos['bezier_points'];//取抛弧线数据
				that.bus_x = that.finger['x']
				that.bus_y = that.finger['y']
				that.hide_good_box = false
				
				that.timer = setInterval(function() {
					index++;
					that.bus_x = bezier_points[index]['x']
					that.bus_y = bezier_points[index]['y']
					if (index >= 28) {
						clearInterval(that.timer);
						that.hide_good_box = true,
							that.hideCount = false,
							that.count = that.count += 1
					}
				}, 20); // 控制动画运动的时间
			},
			/* 向左抛物线 */
			startAnimationLeft: function() {
				var index = 0,
					that = this,
					bezier_points = that.linePos['bezier_points'];
				that.bus_x = that.finger['x']
				that.bus_y = that.finger['y']
				that.hide_good_box = false
				var len = bezier_points.length;
				index = len
				that.timer = setInterval(function() {
					index--;
					that.bus_x = bezier_points[index]['x']
					that.bus_y = bezier_points[index]['y']
					if (index < 1) {
						clearInterval(that.timer);
						that.hide_good_box = true,
							that.hideCount = false,
							that.count = that.count += 1
					}
				}, 20); // 控制动画运动的时间
			}
		}
	}
</script>
<style lang="scss">
	.container {
		.good_box {
			width: 30px;
			height: 30px;
			position: fixed;
			border-radius: 50%;
			overflow: hidden;
			left: 50%;
			top: 50%;
			z-index: +99999;
		}

		.good_box image {
			display: block;
			width: 100%;
			height: 100%;
		}
	}
</style>
