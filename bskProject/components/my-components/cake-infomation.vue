<template>
	<view class="information_box">
		<scroll-view scroll-y="true" style="height: 550upx;">
			<!-- 标题 -->
			<view class="cake_box">
				<view class="cake_title_box">
					<view class="cake_title">
						{{cakeInformation.cakeName}}
					</view>
					<view class="cake_title_english">
						{{cakeInformation.cakeEname}}
					</view>
				</view>
				<view class="cake_price">
					￥{{price}}
				</view>
			</view>
			<!-- 操作表单 -->
			<view class="cake_form">
				<!-- 规格 -->
				<view class="specificat">
					<view class="form_title">
						选择规格:
					</view>
					<view class="specificat_operat">
						<view class="specificat_btn" v-for="(item,index) in cakeInformation.cakeSpecsList" :key="index" :class="isClick==index ? 'btn_click' : ''"
						 @tap="specificatBtnClick(index,item)">
							{{item.cakespecsName}}
						</view>
					</view>
				</view>
				<view class="cake_num">
					<view class="form_title">
						数量:
					</view>
					<view class="cake_choice">
						<img src="../../static/num_2.png" @click="reduceNum"></img>
						<text>{{cakeNumIndex}}</text>
						<img src="../../static/num_1.png" @click="addNum"></img>
					</view>
				</view>
			</view>
			<!-- 蛋糕信息显示 -->
			<view class="cake_information_box">
				<view class="cake_sweet_box">
					<!-- 甜度 -->
					<view class="information_title">
						甜度：
					</view>
					<view class="cake_sweet">
						<span class="sweet" v-for="index of 5" :key="index" v-if="index<cakeInfomationData.cakespecsSweet"></span>
						<span v-for="index of 5" :key="index" v-if="index>=cakeInfomationData.cakespecsSweet"></span>
					</view>
				</view>
				<view class="cake_infomation">
					<view class="infomation_item">
						<view>
							<text>尺寸：</text>
							<text>{{cakeInfomationData.cakespecsSize}}</text>
						</view>
						<view>
							<text>餐具：</text>
							<text>{{cakeInfomationData.cakespecsTableware}}</text>
						</view>
					</view>
					<view class="infomation_item">
						<view>
							<text>人数：</text>
							<text>{{cakeInfomationData.cakespecsPerson}}</text>
						</view>
						<view>
							<text>时间：</text>
							<text>{{cakeInfomationData.cakespecsTime}}</text>
						</view>
					</view>
				</view>
				<text class="cake_details">
					<!-- 扭一扭，舔一舔，泡一泡。当童年经典的奥利奥饼干，碰上酸酸甜甜的蓝莓精灵，一起陷入奶油的醇香怀抱，缓缓融合又各具风味，丝毫不觉唐突，再搭配上浓香四溢的烤芝士圈，美味无限，乐趣无穷。 -->
					{{cakeInformation.cakeInfo}}
				</text>
			</view>
		</scroll-view>
		<!-- 加入购物车按钮 -->
		<view class="join_cakecar_btn" @tap="addCarItem">
			添加到购物车
		</view>
	</view>
</template>

<script>
	export default {
		props: {
			cakeInformation: {
				type: Object,
				default: function() {}
			}
		},
		data() {
			return {
				httpDataUrl: this.$httpUrl.dataUrl,
				cakeInfomationData: "",
				isClick: false,
				//数量
				cakeNumIndex: "1",
				//价格
				price: "",
				//选择的规格
				weightId: ""
			}
		},
		methods: {
			//规格选择
			specificatBtnClick: function(index, item) {
				//数量重置
				this.cakeNumIndex = 1
				//改变样式
				this.isClick = index
				this.cakeInfomationData = this.cakeInformation.cakeSpecsList[index]
				//填入价格
				this.price = this.cakeInformation.cakeSpecsList[index].cakespecsPrice - this.cakeInformation.cakeDiscount
				this.weightId = item.cakespecsId
			},
			//添加数量
			addNum: function() {
				this.cakeNumIndex = parseInt(this.cakeNumIndex) + 1;
				this.price = (this.cakeInfomationData.cakespecsPrice - this.cakeInformation.cakeDiscount) * this.cakeNumIndex
			},
			//减少数量
			reduceNum: function() {
				if (this.cakeNumIndex == 1) return;
				this.cakeNumIndex = parseInt(this.cakeNumIndex) - 1
				this.price = (this.cakeInfomationData.cakespecsPrice - this.cakeInformation.cakeDiscount) * this.cakeNumIndex
			},
			//加入购物车
			addCarItem: function(e) {
				//console.log(this.$httpUrl.dataUrl)
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
							uni.navigateTo({
								url:'../../pages/login/login'
							})
							return
						}
						//用户已登录
						if (res.data.code == 0) {
							//将登陆用户加入全局变量
							this.$User.addUser(res.data.data[0])
							// 加入购物车开始
							uni.request({
								url: this.httpDataUrl + '/cakeCar/addCakeCar',
								data: {
									carUserid: this.$User.user.userId,
									carCakeid: this.cakeInformation.cakeId,
									carNum: this.cakeNumIndex,
									carSpecsid: this.weightId
								},
								success: (res) => {
									console.log(res)
									//提示信息
									uni.showToast({
										title: '加入成功',
										icon: 'none'
									});
									//加入购物车动画
									this.$emit('PupopClose', e)
								}
							})
						}
					}
				})
				// var cakeData = {
				// 	// cakeImg:this.cakeInformation.cakeImg[0].img,
				// 	// cakeName: this.cakeInfomationData.cakeName,
				// 	// cakeNameEnglish: this.cakeInfomationData.cakeNameEnglish,
				// 	// cakePirce: this.cakeInfomationData.cakePirce,
				// 	// cakeWeight: this.weight,
				// 	// cakeNum: this.cakeNumIndex
				// };
				//发送给服务端加入购物车
				// uni.request({

				// })
				// 	this.$cakeCar.pushCar(cakeData);
				//提示信息
				// uni.showToast({
				// 	title: '加入成功',
				// 	icon: 'none'
				// });
				//加入购物车动画
				// this.$emit('PupopClose',e)
			},
			//初始化
			Initialization: function() {
				this.cakeInfomationData = this.cakeInformation.cakeSpecsList[0]
				this.price = this.cakeInformation.cakeSpecsList[0].cakespecsPrice - this.cakeInformation.cakeDiscount
				this.weightId = this.cakeInformation.cakeSpecsList[0].cakespecsId
				this.cakeNumIndex = 1
				this.isClick = false
			}
		},
		// #ifdef H5
		// beforeUpdate() {
		// 	this.Initialization()
		// },
		// Update() {
		// 	this.Initialization()
		// },
		// #endif
		// #ifdef APP-PLUS
		mounted() {
			this.Initialization()
		},
		// #endif
		//vue.js生命周期函数 在数据编译html之前调用
		created() {
			this.Initialization()
			console.log('onCreated')
			console.log(this.cakeInfomationData)
		}
	}
</script>

<style>
	.information_box {
		width: 100%;
		height: 100%;
		background-color: #FFFFFF;
		border-top: #25E0E4 5px solid;
		/* position: absolute;
		bottom: 0upx;
		left: 3%; */
		box-sizing: border-box;
		padding: 40upx 30upx;
	}

	.cake_box {
		width: 100%;
		overflow: hidden;
		position: relative;
	}

	.cake_box .cake_title_box {
		float: left;
		height: 100%;
		font-size: 28upx;

	}

	.cake_box .cake_title_box .cake_title {
		font-size: 36upx;
		color: #000000;
		font-weight: bold;
	}

	.cake_box .cake_title_box .cake_title_english {
		color: #9e9e9e;
	}

	.cake_box .cake_price {
		position: absolute;
		color: #FF1850;
		font-size: 44upx;
		font-weight: bold;
		right: 0upx;
	}

	.specificat {
		margin-top: 30upx;
		overflow: hidden;
		height: 60upx;
	}

	.form_title {
		display: block;
		width: 30%;
		font-size: 28upx;
		float: left;
		height: 100%;
		line-height: 50upx;
	}

	.specificat .specificat_operat {
		float: left;
		display: flex;
		flex-direction: row;
		width: 70%;
	}

	.specificat .specificat_operat .specificat_btn {
		width: 90upx;
		height: 50upx;
		font-size: 28upx;
		border: #CCCCCC 1px solid;
		color: #CCCCCC;
		border-radius: 10upx;
		text-align: center;
		line-height: 50upx;
		margin-right: 10upx;
	}

	.specificat .specificat_operat .btn_click {
		color: #FFFFFF !important;
		border: #25E0E4 1px solid !important;
		background: #25E0E4 !important;
	}

	.cake_num {
		margin-top: 30upx;
	}

	.cake_choice {
		width: 170upx;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
	}

	.cake_choice img {
		display: inline-block;
		width: 50upx;
		height: 50upx;
	}

	.cake_sweet_box {
		margin-top: 30upx;
		overflow: hidden;
		height: 60upx;
	}

	.information_title {
		display: block;
		width: 15%;
		font-size: 28upx;
		float: left;
		height: 100%;
		line-height: 50upx;
	}

	.cake_sweet_box .cake_sweet {
		width: 80%;
		height: 100%;
		float: left;
	}

	.cake_sweet_box .cake_sweet span {
		display: block;
		width: 50upx;
		height: 50upx;
		margin-right: 2upx;
		background-image: url('../../static/sugar1.png');
		background-size: 100% 100%;
		background-repeat: no-repeat;
		float: left;
	}

	.cake_sweet_box .cake_sweet .sweet {
		background-image: url('../../static/sugar2.png');
	}

	.cake_infomation {
		width: 100%;
		overflow: hidden;
	}

	.cake_infomation .infomation_item {
		width: 50%;
		float: left;
	}

	.cake_infomation .infomation_item view {
		font-size: 28upx;
		margin-top: 20upx;
	}

	.cake_details {
		display: block;
		font-size: 28upx;
		margin-top: 40upx;
		color: #9e9e9e;
	}

	.join_cakecar_btn {
		widows: 100%;
		height: 100upx;
		background: linear-gradient(to right, #FE7196, #FF1850);
		border-radius: 100upx;
		color: #FFFFFF;
		text-align: center;
		line-height: 100upx;
		margin-top: 40upx;
	}
</style>
