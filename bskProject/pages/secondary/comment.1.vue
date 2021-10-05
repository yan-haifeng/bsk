<template>
	<view>
		<uni-nav-bar title="评价">
			<view slot="left">
				<image src="../../static/return.png" style="width: 40upx; height: 40upx;position: relative; top: 8upx;margin-left: 18upx;"></image>
			</view>
		</uni-nav-bar>
		
		<view class="cakeEvaluation">
			<view class="button1">
				<view class="buttonAll">全部({{buttonA[0].all}})</view>
				<view class="buttonPhone">有图({{buttonA[0].phone}})</view>
				<view class="buttonGood">好评({{buttonA[0].good}})</view>
				<view class="buttonMiddle">中评({{buttonA[0].middle}})</view>
				<view class="buttonBad">差评({{buttonA[0].bad}})</view>
			</view>
			<view class="button2">
				<view class="buttonTaste">味道好({{buttonA[0].taste}})</view>
				<view class="buttonBeautiful">好看({{buttonA[0].beautiful}})</view>
			</view>	
		</view>
		
		<view class="writingEvaluation">
			<view class="cakeEvaluation_txt">
				<image class="cakeEvaluation_img" src="../../static/menu4.png"  style="width: 80upx; height: 80upx; padding: 6upx;"></image>
				<span class="cakeEvaluation_txt1"><p>哎咿呀哦</p><p style="font-size: 8upx; color: #9E9E9E; ">2018-18-18</p></span>
				<view class="cakeEvaluation_start">
					<image src="../../static/comment_stars.png" mode="aspectFill" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars.png" mode="aspectFill" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars.png" mode="aspectFill" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars.png" mode="aspectFill" style="width: 40upx; height: 40upx;"></image>
					<image src="../../static/comment_stars1.png" mode="aspectFill" style="width: 40upx; height: 40upx;"></image>
				</view>
			</view>
			<view class="cakeEvaluation_txtShow">
				<p>{{commentText}}</p>
				<view class="cakeEvaluation_txtShowImg">
					<image  v-for="(item , index) in commentImg" :key="index" :src="item.img" mode="aspectFill" style="width: 180upx; height: 180upx; margin: 5upx 10upx; border-radius: 10upx;"></image>
				</view>
				
			</view>
		</view>
		
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	
	
	
	export default {
		data() {
			
			return {
				buttonA: [
					{
						"all": "38",
						"phone": "10",
						"good": "30",
						"middle": "6",
						"bad": "2",
						"taste": "26",
						"beautiful":"11"
					}
					],
				commentImg: [{
						img: "https://res.bestcake.com/m-images/banner_list/421603304217817540.jpg"
					},
					{
						img: "https://res.bestcake.com/m-images/banner_list/366895504692554800.jpg",
					},
					{
						img: "https://res.bestcake.com/m-images/banner_list/421603304217817540.jpg"
					}
					],	
					
					commentText:'asgdkasdksahdk'
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
		border-bottom: 10upx solid #FAFAFA;
	}
	.cakeEvaluation .button1{
		display: flex;
		padding: 32upx;
		font-size: 12upx;
	}
	.cakeEvaluation .button2{
		display: flex;
		padding: 0 0 0 32upx;
		font-size: 12upx;
	}
	.buttonAll{
		color: #FFFFFF;
		padding: 8upx;
		background-color: #FA2C60;
		border-radius: 10upx;
	}
	.buttonPhone{
		padding: 8upx;
		margin-left: 25upx;
		background-color: #FBDCE7;
		border-radius: 10upx;
	}
	.buttonGood{
		padding: 8upx;
		margin-left: 25upx;
		background-color: #FBDCE7;
		border-radius: 10upx;
	}
	.buttonMiddle{
		padding: 8upx;
		margin-left: 25upx;
		background-color: #FBDCE7;
		border-radius: 10upx;
	}
	.buttonBad{
		padding: 8upx;
		margin-left: 25upx;
		background-color: #F2F2F2;
		border-radius: 10upx;
	}
	.buttonTaste{
		padding: 8upx;
		background-color: #FBDCE7;
		border-radius: 10upx;
	}
	.buttonBeautiful{
		padding: 8upx;
		margin-left: 25upx;
		background-color: #FBDCE7;
		border-radius: 10upx;
	}
	.writingEvaluation{
		border-top: 3upx solid #FAFAFA;
		border-bottom: 3upx solid #FAFAFA;
		margin: 0 20upx;
		left: 100upx;
		height: auto;
		background-color: #FFFFFF;
	}
	.cakeEvaluation_txt{
		padding: 10upx;
		display: flex;
	}
	.cakeEvaluation_img{
		flex: 1;
	}
	.cakeEvaluation_txt1{
		flex: 4.2;
		padding-left: 15upx;
	}
	.cakeEvaluation_start{
		flex: 2.5;
	}
	.cakeEvaluation_txtShowImg{
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: space-between;
		padding: 0 30upx;
		box-sizing: border-box;  
	}
	
</style>
