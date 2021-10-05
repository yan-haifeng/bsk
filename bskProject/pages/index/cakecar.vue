<template>
	<view>
		<!-- 标题栏 -->
		<uni-nav-bar title="购物车" fixed="true" paddingTop="0" borderTop="20px solid #fff">
			<!-- 点击清空清空购物车 -->
			<view slot="right" style="font-size: 28upx;" v-if="haveCake" @tap="cleanCar">
				清空
			</view>
		</uni-nav-bar>
		<!-- 物品列表 -->
		<view class="cake_item_wapper">
			<view class="img_box" v-if="!haveCake"></view>
			<!-- 购物列表循环 -->
			<cake-car-item v-for="(item,index) in cars" :key="index" :img="httpStaticUrl+item.cakeInfoList[0].cakeImg" :cakeName="item.cakeInfoList[0].cakeName"
			 :cakeNameEnglish="item.cakeInfoList[0].cakeEname" :cakePirce="item.cakeSpecsList[0].cakespecsPrice" :cakeWeight="item.cakeSpecsList[0].cakespecsName"
			 v-if="haveCake" :cakeNum="item.carNum" @changeNum='changeNum' :index="index" @refush='refush' :NumKey="NumKey" ref="refs"></cake-car-item>
		</view>
		<!-- 猜你喜欢 -->
		<view class="guess_you_like">
			<view class="like_title">
				猜你喜欢
			</view>
			<view class="like_box">
				<cake-card-mini v-for="(item,index) in like" :key="index" :cake="item" :haveAddBtn="false"></cake-card-mini>
			</view>
		</view>
		<!-- 填充 -->
		<view class="fill" v-if="haveCake"></view>
		<!-- 购物车结算 -->
		<view class="settlement_box" v-if="haveCake">
			<view class="settlement_content">
				<view>￥{{carPrice}}</view>
			</view>
			<view class="go_settlement" @tap="toSettlement">
				去结算
			</view>
		</view>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	import uniNavBar1 from "@/components/uni-nav-bar1/uni-nav-bar1.vue"
	import cakeCardMini from "@/components/my-components/cake-card-mini.vue"
	import cakeCarItem from "@/components/my-components/cake-car-item.vue"
	export default {
		data() {
			return {
				// 购物车数据
				cars: [],
				// 猜你喜欢数据
				like: [],
				haveCake: false,
				carPrice: 0,
				NumKey: 0,
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl
			}
		},
		components: {
			uniNavBar,
			uniNavBar1,
			cakeCardMini,
			cakeCarItem
		},
		methods: {
			//改变购买数量
			changeNum: function(cakeNum) {
				//像服务器发送改变的数量
				uni.request({
					url: this.httpDataUrl + '/cakeCar/editCakeCar',
					data: {
						carId: this.cars[cakeNum[1]].carId,
						carNum: cakeNum[0].toString()
					},
					success: (res) => {
						//console.log(res)
						//局部购物车蛋糕数量
						this.cars[cakeNum[1]].carNum = cakeNum[0].toString();
						//全局购物车蛋糕数量
						this.$cakeCar.refCar(this.cars);
						//console.log(this.car)
						this.countPirce();
					}
				})

			},
			//计算购物车价格
			countPirce: function() {
				var price = 0;
				for (var i = 0; i < this.cars.length; i++) {
					price = price + this.cars[i].cakeSpecsList[0].cakespecsPrice * this.cars[i].carNum;
				}
				this.carPrice = price;
			},
			//清空购物车
			cleanCar: function() {
				let that = this
				uni.showModal({
					title: '清空',
					content: '确定要清空购物车吗?',
					success: function(res) {
						if (res.confirm) {
							//console.log('清空')
							//执行清空购物车
							//向服务器发送清空购物车指令
							uni.request({
								url: that.httpDataUrl + '/cakeCar/removeCakeCarByUserId?carUserid=' + that.$User.user.userId,
								success: (res) => {
									if (res.data.code == 0) {
										//清空成功
										//清空全局变量
										that.$cakeCar.cleanCakeCar()
										//清空局部变量
										that.cars = []
									}
								}
							})
							that.itemOnShow()
						}

						if (res.cancel) {
							//console.log('取消')
						}
					}
				})
			},
			itemOnShow: function() {
				//像服务器获取用户是否登录
				//判断用户是否登录
				uni.request({
					url: this.httpDataUrl + '/isLogin',
					data:{
						sessionid: this.$User.session
					},
					success: (res) => {
						//console.log(res);
						//用户未登录：
						if (res.data.code == 1) {
							this.haveCake = false
							return
						}
						//用户已登录
						if (res.data.code == 0) {
							//将登陆用户加入全局变量
							this.$User.addUser(res.data.data[0])
							//像服务器获取购物车信息
							uni.request({
								url: this.httpDataUrl + '/cakeCar/getAllCakeCarByUserIdNotBuy?carUserid=' + this.$User.user.userId,
								success: (res) => {
									//console.log(res)
									if (res.data.code == 0) {
										//查询成功
										//将购物车信息放入全局变量中
										this.$cakeCar.refCar(res.data.data)
										//将购物车信息放入局部变量中
										this.cars = res.data.data
										//初始化是否有蛋糕
										this.haveCake = false
										//this.cars = this.$cakeCar.car
										if (this.$cakeCar.car.length == 0) {
											this.haveCake = false
										} else {
											//组件刷新
											// this.$nextTick(function() {
											//cnm	
											// })
											this.haveCake = true
										}
										//console.log(this.$cakeCar.car)
										//console.log(this.cars)
										this.countPirce()
									}
								}
							})
						}
					}
				})
			},
			toSettlement: function() {
				uni.navigateTo({
					url: '../secondary/order-details'
				})
			}
		},
		onHide() {
			this.cars = []
		},
		onShow() {
			this.itemOnShow()
		},
		onLoad() {
			//向服务器获取猜你喜欢
			uni.request({
				url: this.httpDataUrl + "/cakeInfo/getCakeInfoByPopulity?randomSize=4&randomNum=2",
				success: (res) => {
					this.like = res.data.data;
				}
			});
			uni.request({
				url: this.httpDataUrl + '/isLogin',
				data:{
					sessionid: this.$User.session
				},
				success: (res) => {
					//用户未登录：
					if (res.data.code == 1) {
						uni.navigateTo({
							url: '../login/login'
						})
						return
					}
				}
			})
		}
	}
</script>

<style>
	.cake_item_wapper {
		min-height: 600upx;
		border-bottom: 20upx solid #F4F4F4;
	}

	.cake_item_wapper .img_box {
		height: 600upx;
		background-image: url("../../static/carnull.png");
		background-repeat: no-repeat;
		background-position: center;
		background-size: 800upx 650upx;
	}

	.guess_you_like .like_title {
		height: 60upx;
		text-align: center;
		line-height: 60upx;
		font-size: 28upx;
		padding: 20upx 0;
	}

	.guess_you_like .like_box {
		width: 100%;
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: space-between;
		padding: 0 30upx;
		box-sizing: border-box;
	}

	/* 结算 */
	.settlement_box {
		width: 100%;
		height: 100upx;
		background: #FFFFFF;
		position: fixed;
		/* bottom: 50px; */
		/* #ifdef H5 */
		bottom: 50px; 
		/* #endif */
		/* #ifdef APP-PLUS */
		bottom: 0px;
		/* #endif */
		overflow: hidden;
		z-index: 999;
		border-top: 1px solid #F4F4F4;
	}

	.settlement_box .settlement_content {
		height: 100%;
		width: 75%;
		float: left;
	}

	.settlement_content view {
		height: 100%;
		display: block;
		margin-left: 50upx;
		line-height: 100upx;
		color: #FF1850;
		font-size: 40upx;
		font-weight: bold;
	}

	.go_settlement {
		width: 25%;
		height: 100%;
		float: left;
		line-height: 100upx;
		text-align: center;
		font-size: 34upx;
		background: linear-gradient(to left, #FE7196, #FF1850);
		color: #FFFFFF;
	}

	.fill {
		height: 100upx;
	}
</style>
