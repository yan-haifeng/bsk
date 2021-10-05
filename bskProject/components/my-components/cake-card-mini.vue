<template>
	<view class="cake-card-mini" @tap.stop="toCakeInfomation">
		<view class="cake_img" :style="{'background-image': 'url('+httpStaticUrl+cake.cakeImg+')'}"></view>
		<view class="card-mini-content">
			<view class="card-mini-title">
				<text class="card-mini-title-china">{{cake.cakeName}}</text>
			</view>
			<view class="card-mini-pirce">
				<text class="card-mini-pirce-new">￥{{cake.cakeSpecsList[0].cakespecsPrice-cake.cakeDiscount}}<text class="card-mini-pirce-weight">/1.2磅<!-- {{cake.cakeSpecsList[0].cakespecsName}} --></text></text>
				<view class="card-mini-numBar" @tap.stop="popupOpen" v-if="haveAddBtn"></view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data(){
			return{
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl
			}
		},
		props: {
			cake:{
				type:Object
			},
			haveAddBtn:{
				type:Boolean,
				default:true
			}
		},
		methods: {
			toCakeInfomation: function() {
				uni.navigateTo({
					url: '../../pages/secondary/cake-details?id='+this.cake.cakeId
				})
			},
			popupOpen: function() {
				//console.log('aaa')
				this.$emit('PupopOpen',this.cake)
			}
		}
	}
</script>

<style>
	.cake-card-mini {
		width: 330upx;
		height: auto;
		border-radius: 20upx;
		box-shadow: -10upx 10upx 10upx #F3F3F3;
		position: relative;
		margin-bottom: 40upx;
		overflow: hidden;
	}

	.cake_img {
		width: 330upx;
		height: 330upx;
		border-radius: 20upx;
		z-index: 0;
		background-size: 100% auto;
		background-position: top;
		background-repeat: no-repeat;
	}

	.card-mini-content {
		width: 100%;
		background: rgba(250,250,250,0.6);
		position: absolute;
		bottom: 0upx;
		box-sizing: border-box;
		padding: 20upx 30upx;
		border-radius: 0 0 20upx 20upx;
		overflow: hidden;
		z-index: 1;
	}

	.card-mini-title {
		font-size: 36upx;
	}

	.card-mini-title-china {
		font-size: 30upx;
		display: block;
		font-weight: bold;
		margin-bottom: 5upx;
	}

	.card-mini-title-english {
		font-size: 24upx;
		display: block;
		color: #9e9e9e;
	}

	.card-mini-pirce {
		display: flex;
		flex-direction: row;
		align-items: center;
		height: 38rpx;
		justify-content: space-between;
	}

	.card-mini-pirce text {
		font-size: 24upx;
		color: #9e9e9e;
	}

	.card-mini-pirce .card-mini-pirce-old {
		text-decoration: line-through;
		margin-right: 10upx;
	}

	.card-mini-pirce .card-mini-pirce-new {
		font-size: 30upx;
		color: #FF1850;
		font-weight: bold;
		margin-right: 5upx;
	}

	.card-mini-content .card-mini-numBar {
		width: 50upx;
		height: 50upx;
		background-image: url('../../static/num_1.png');
		background-size: 80% 80%;
		background-position: center;
		background-repeat: no-repeat;

	}
</style>
