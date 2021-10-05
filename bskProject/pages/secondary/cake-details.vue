<template>
	<view>
		<!-- 标题栏 -->
		<uni-nav-bar left-icon="back" fixed="true" paddingTop="0" borderTop="20px solid rgba(0,0,0,0)" backgroundColor="rgba(0,0,0,0)"
		 @clickLeft="toBack"></uni-nav-bar>
		<!-- 图片轮播 -->
		<swiper class="swiper" indicator-dots="true" autoplay="true" interval="5000" duration="1500">
			<swiper-item v-for="(item , index) in cakeinfomation.cakeImgList" :key="index">
				<image :src="httpStaticUrl+item" mode="aspectFill"></image>
			</swiper-item>
		</swiper>
		<!-- 填写信息 -->
		<view class="infomation_wapper">
			<cake-infomation-bar ref="infomationBar" :cakeInformation="cakeinfomation" @PupopClose="flyCar" :key="infomationKey"></cake-infomation-bar>
		</view>
		<!-- 加入购物车动画 cartx 和 carty 是购物车位置在屏幕位置的比例 例如左上角x0.1 y0.1 右下角 x0.9 y0.9-->
		<shopCarAnimation ref="carAnmation" cartx="0.9" carty="0.3"></shopCarAnimation>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	import cakeInfomationBar from "@/components/my-components/cake-infomation.vue"
	import shopCarAnimation from '@/components/fly-in-cart/fly-in-cart.vue'
	export default {
		components: {
			uniNavBar,
			cakeInfomationBar,
			shopCarAnimation
		},
		data() {
			return {
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl,
				cakeinfomation: {},
				infomationKey:0
			}
		},
		methods: {
			toBack: function() {
				uni.navigateBack({
					delta: 1
				})
			},
			flyCar: function(e) {
				console.log(e)
				this.$refs.carAnmation.touchOnGoods(e);
			}
		},
		onLoad(option) {
			console.log(option.id)
			//通过蛋糕id拿到蛋糕
			uni.request({
				url:this.httpDataUrl+'/cakeInfo/getCakeById?cakeId='+option.id,
				success: (res) => {
					this.cakeinfomation = res.data.data[0]
					//console.log(this.cakeinfomation)
					this.infomationKey++
					this.$refs.infomationBar.Initialization()
				}
			})
		}
	}
</script>

<style>
	.swiper {
		height: 600upx;
		position: relative;
		top: -130upx;
		z-index: 1;
	}

	swiper-item image {
		width: 100%;
		height: 630upx;
	}

	.infomation_wapper {
		position: absolute;
		bottom: 0upx;
		left: 3%;
		z-index: 2;
		margin: 3% auto;
		width: 94%;
	}
</style>
