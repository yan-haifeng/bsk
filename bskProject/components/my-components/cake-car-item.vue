<template>
	<view class="car_cake_item">
		<!-- <image :src="img" class="car_cake_img"></image> -->
		<view class="img" :style="{'background-image': 'url('+img+')'}"></view>
		<view class="cake_content">
			<text class="cake_title">{{cakeName}}</text>
			<text class="cake_english_title">{{cakeNameEnglish}}</text>
			<text class="cake_weight">规格：{{cakeWeight}}</text>
		</view>
		<view class="cake_operation">
			<text class="cake_pirce">￥{{cakePirce}}</text>
			<!-- 添加减少组件 -->
			<view class="cake_choice">
				<img src="../../static/num_2.png" @click="reduceNum"></img>
				<text :key='NumKey'>{{cakeNumIndex}}</text>
				<img src="../../static/num_1.png" @click="addNum"></img>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		props: {
			img : {
				type : String,
				default : ""
			},
			cakeName : {
				type : String,
				default : ""
			},
			cakeNameEnglish:{
				type : String,
				default : ""
			},
			cakePirce: {
				type : String,
				default : ""
			},
			cakeWeight:{
				type : String,
				default : ""
			},
			cakeNum:{
				type : String,
				default : ""
			},
			index:{} ,//for循环坐标，勿动！！！！！！！
			NumKey:{}
		},
		data(){
			return{
				cakeNumIndex:this.cakeNum //cakeNumIndex接收父组件传来的cakeNum值；
			}
		},
		methods:{
			addNum:function(){
				this.cakeNumIndex = parseInt(this.cakeNumIndex) + 1;
				this.$emit('changeNum',[this.cakeNumIndex,this.index]);
				//console.log(this.cakeNumIndex)
			},
			reduceNum:function(){
				if(this.cakeNumIndex==1) return;
				this.cakeNumIndex = parseInt(this.cakeNumIndex) - 1;
				this.$emit('changeNum',[this.cakeNumIndex,this.index]);
			}
		}
	}
</script>

<style>
	/* 购物车 */
	.car_cake_item {
		height: 230upx;
		box-sizing: border-box;
		padding: 40upx;
		overflow: hidden;
		border-bottom: 1px solid #F4F4F4;
	}

	.car_cake_item .car_cake_img {
		height: 100%;
		width: 150upx;
		float: left;
		margin-right: 40upx;
	}
	
	.img{
		height: 100%;
		width: 150upx;
		float: left;
		margin-right: 40upx;
		background-size: 100% auto;
		background-position: center;
		background-repeat: no-repeat;
	}

	.cake_content {
		height: 100%;
		float: left;
		position: relative;
		overflow: hidden;
	}

	.cake_content text {
		display: block;
		font-size: 24upx;
		color: #9e9e9e;
		margin-bottom: 4upx;
	}

	.cake_content .cake_title {
		font-size: 32upx;
		color: #333333;
		font-weight: bold;
	}

	.cake_content .cake_weight {

	}

	.cake_operation {
		height: 100%;
		float: right;
		position: relative;
	}

	.cake_operation .cake_pirce {
		font-size: 32upx;
		color: #333333;
		font-weight: bold;
		position: absolute;
		right: 0;
	}

	.cake_choice {
		width: 170upx;
		position: absolute;
		right: 0;
		bottom: 0;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
	}

	.cake_choice img {
		display: inline-block;
		width: 50upx;
		height: 50upx;
	}
</style>
