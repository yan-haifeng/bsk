<template>
	<view>
		<uni-nav-bar title="评价">
			<view slot="left">
				<image src="../../static/return.png" style="width: 40upx; height: 40upx;position: relative; top: 8upx;margin-left: 18upx;"></image>
			</view>
		</uni-nav-bar>
		<view class="cakeEvaluation">
			<image class="cakeEvaluation_img" src="../../static/cace.png" style="width: 100upx; height: 100upx;"></image>
			<view class="cakeEvaluation_txt">
				<span>商品满意度</span>
				<view class="cakeEvaluation_start">
					<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars1.png" style="width: 40upx; height: 40upx;"></image>
				</view>
			</view>
		</view>
		
		<view class="writingEvaluation">
			 <textarea type="text" placeholder="请在这儿输入您的评价."  style="160upx" ></textarea>
				<image src="../../static/comment_addphoto.png" mode="aspectFit" style="width: 150upx; height: 150upx;"></image>
			</view>
		
		<view class="logisticsService">
			<span>物流服务:</span>
			<view class="logisticsService_img">
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars1.png" style="width: 40upx; height: 40upx;"></image>
			</view>
		</view>
		<view class="logisticsService">
			<span>服务态度:</span>
			<view class="logisticsService_img">
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars.png" style="width: 40upx; height: 40upx;"></image>
				<image src="../../static/comment_stars1.png" style="width: 40upx; height: 40upx;"></image>
			</view>
		</view>
		<view  class="button1" >
			<text class="button_s">发布</text>
		</view>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	
	
	
	export default {
		data() {
			return {
				
			}
		},
		components: {
			uniNavBar,	
		},
		
	}
</script>

<style>
	*{margin: 0;padding: 0;}
	.cakeEvaluation{
		width: 100%;
		height: 180upx;
		border-top: 10upx solid #FAFAFA;
		margin: 0 auto ;
		display: flex;
		justify-content: space-around;

	}
	.cakeEvaluation_img{
		border: 1upx solid #F1F1F1;
		margin: 38upx 48upx;
		width: 20%;
		
	}
	.cakeEvaluation_txt{
		margin: 35upx -20upx;
		width: 80%;
		height: 200upx;
	}
	.cakeEvaluation_txt span{
		top: 5upx;
		font-size: 17upx;
		line-height: 25upx;
	}
	.cakeEvaluation_txt image{
		
		margin: 0 10upx;	
	}
	.cakeEvaluation_txt image:nth-child(1){
		margin: 0upx;
	}
	.writingEvaluation{
		border-top: 2upx solid #FAFAFA;
		border-bottom: 2upx solid #FAFAFA;
		margin: 0 20upx;
		left: 100upx;
		height: 550upx;
		background-color: #FFFFFF;
	}
	.writingEvaluation image{
		margin: 10upx 35upx;
	}
	.logisticsService{
		margin: 30upx -20upx 0 0;
		width: 80%;
		height: 40upx;
		display: flex;
	}
	.logisticsService span{
		margin: 5upx 55upx;
		flex: left;
		font-size: 18upx;
		line-height: 25upx;
	}
	.logisticsService_img{
		margin: -5upx -30upx;
	}
	.logisticsService_img image{
		margin: 0 10upx;
	}
	.button1{
		margin-left: 120upx;
		margin-top: 80upx;
		height: 85upx;
		width: 500upx;
		border-radius: 100upx;
		background-image: linear-gradient(-45deg, #96deda 0%, #8ec5fc 100%);
		vertical-align: middle;
		text-align: center;
	}
	.button_s{
		line-height: 85upx;
		vertical-align: middle;
		text-align: center;
		vertical-align:middle;
		color: #FFFFFF;
		font-size: 37upx;
	}
</style>
