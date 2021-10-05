<template>
	<view class="my-cake-card" @tap.stop="toCakeInfomation">
		<image :src="httpStaticUrl+cake.cakeImg" class="card-img"></image>
		<view class="card-content">
			<view class="card-title">
				<text class="card-title-china">{{cake.cakeName}}</text>
				<text class="card-title-english">{{cake.cakeEname}}</text>
			</view>
			<view class="card-pirce">
				<text class="card-pirce-old" v-if="haveCheap">{{'￥'+cake.cakeSpecsList[0].cakespecsPrice}}</text>
				<text class="card-pirce-new">￥{{cake.cakeSpecsList[0].cakespecsPrice-cake.cakeDiscount}}</text>
				<text class="card-pirce-weight">/{{cake.cakeSpecsList[0].cakespecsName}}</text>
			</view>
			<view class="card-numBar" @tap.stop="popupOpen"></view>
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl
			}
		},
		props:{
			cake:{
				type:Object
			},
			haveCheap:{
				type:Boolean,
				default:false
			}
		},
		methods:{
			toCakeInfomation: function(){
				uni.navigateTo({
					url:'../../pages/secondary/cake-details?id='+this.cake.cakeId
				})
			},
			popupOpen: function(){
				//console.log('aaa')
				this.$emit('PupopOpen',this.cake)
			}
		}
	}
</script>

<style>
	.my-cake-card{
		width: 100%;
		height: 400upx;
		border-radius: 20upx;
		box-shadow: -10upx 10upx 10upx #F3F3F3;
		position: relative;
		margin-bottom: 40upx;
	}
	
	.my-cake-card image{
		width: 100%;
		height: 100%;
		border-radius: 20upx;
	}
	
	.card-content{
		width: 100%;
		height: 35%;
		background: rgba(250,250,250,0.9);
		position: absolute;
		bottom: 0upx;
		box-sizing: border-box;
		padding: 20upx 30upx;
		border-radius: 0 0 20upx 20upx;
	}
	
	.card-title{
		float: left;
		font-size: 36upx;
	}
	
	.card-title-china{
		font-size: 30upx;
		display: block;
		font-weight: bold;
		margin-bottom: 5upx;
	}
	
	.card-title-english{
		font-size: 24upx;
		display: block;
		color: #9e9e9e;
	}
	
	.card-pirce{
		float: left;
		margin-left: 20upx;
		display: flex;
		flex-direction: row;
		align-items: center;
		height: 38rpx;
	}
	
	.card-pirce text{
		font-size: 24upx;
		color: #9e9e9e;
	}
	
	.card-pirce .card-pirce-old{
		text-decoration: line-through;
		margin-right: 10upx;
	}
	.card-pirce .card-pirce-new{
		font-size: 30upx;
		color: #FF1850;
		font-weight: bold;
		margin-right: 5upx;
	}
	.card-content .card-numBar{
		position: relative;
		top: 30upx;
		width: 50upx;
		height: 50upx;
		background-image: url('../../static/num_1.png');
		background-size: 80% 80%;
		float: right;
		background-position: center;
		background-repeat: no-repeat;
	}
</style>
