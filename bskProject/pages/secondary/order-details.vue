<template>
	<view>
		<!-- 标题栏 -->
		<uni-nav-bar fixed="true" title="确认订单" paddingTop="20px" left-icon="back" @clickLeft="toBack"></uni-nav-bar>
		<!-- 用户信息 -->
		<view class="item_card">
			<view class="user_infomation_box">
				<view>收货人：{{addressName}}</view>
				<view>联系电话：{{addressTel}}</view>
				<view>收货地址：{{addressLocation}}</view>
				<!-- 更换按钮 -->
				<view class="cangeAddress" @tap="showPopup">
					更换
				</view>
			</view>
		</view>
		<!-- 蛋糕信息及配送时间 -->
		<view class="form_card">
			<!-- 蛋糕信息 -->
			<view class="form_item cake_information">
				<view class="item_left">
					<!-- <image v-for="(item,index) in carInfomation" :key="index" :src="httpStaticUrl+item.cakeInfoList[0].cakeImg" v-if="index<3"></image> -->
					<view class="image" v-for="(item,index) in carInfomation" :key="index" :style="{'background-image': 'url('+httpStaticUrl+item.cakeInfoList[0].cakeImg+')'}" v-if="index<3"></view>
				</view>
				<view class="item_right">
					<view class="item_content">
						共{{num}}件
					</view>
					<span></span>
				</view>
			</view>
			<!-- 配送时间 -->
			<view class="form_item" @tap="toDaelitime">
				<view class="item_left">
					<view class="left_text">
						配送时间
					</view>
				</view>
				<view class="item_right">
					<view class="item_content">
						{{time}}
					</view>
					<span></span>
				</view>
			</view>
			<!-- 发票 -->
			<view class="form_item" @tap="showMaintain">
				<view class="item_left">
					<view class="left_text">
						发票
					</view>
				</view>
				<view class="item_right">
					<view class="item_content">
						普通（个人）
					</view>
					<span></span>
				</view>
			</view>
		</view>
		<!-- 优惠券 -->
		<view class="form_card">
			<!-- 优惠券 -->
			<view class="form_item" @tap="showMaintain">
				<view class="item_left">
					<view class="left_text">
						优惠券
					</view>
				</view>
				<view class="item_right">
					<view class="item_content">
						无可用
					</view>
					<span></span>
				</view>
			</view>
			<!-- 兑换券 -->
			<view class="form_item" @tap="showMaintain">
				<view class="item_left">
					<view class="left_text">
						兑换券
					</view>
				</view>
				<view class="item_right">
					<view class="item_content">
						无可用
					</view>
					<span></span>
				</view>
			</view>
			<!-- 吉列币 -->
			<view class="form_item" @tap="showMaintain">
				<view class="item_left">
					<view class="left_text">
						吉列币
					</view>
				</view>
				<view class="item_right">
					<view class="item_content">
						无可用
					</view>
					<span></span>
				</view>
			</view>
		</view>
		<!-- 价格信息 -->
		<view class="price_box">
			<view>
				<text class="price">￥{{price}}</text>
				<text class="title">小计</text>
				<text>共计{{num}}件商品</text>
			</view>
			<view>
				<text class="price">
					￥30.00
				</text>
				<text class="title">
					运费
				</text>
			</view>
		</view>
		<!-- 填充 -->
		<view class="fill"></view>
		<!-- 结算组件 -->
		<view class="settlement_box">
			<view class="settlement_content">
				<view>￥{{price+30}}</view>
			</view>
			<view class="go_settlement" @tap="subOrder">
				去支付
			</view>
		</view>
		<!-- 地址选择组件 -->
		<popup-layer ref="popupRef" :direction="'top'">
			<view class="address_box">
				<scroll-view scroll-y="true" style="height: 700upx;">
			<view class="list">
				<view class="row" v-for="(row,index) in addressList" :key="index" @tap="rowClick(row)">
					<view class="left">
						<view class="head">
							{{row.addressNameFirst}}
						</view>
					</view>
					<view class="center">
						<view class="name-tel">
							<view class="name">{{row.addressName}}</view>
							<view class="tel">{{row.addressPhone}}</view>
							<view class="default" v-if="row.isDefault">
								默认
							</view>
						</view>
						<view class="address">
							{{row.addressInfo}} {{row.addressDetail}}
						</view>
					</view>
				</view>
			</view>
				</scroll-view>
			</view>
		</popup-layer>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	import popupLayer from "@/components/popup-layer/popup-layer.vue"
	export default {
		data() {
			return {
				carInfomation: [],
				num: 0,
				price: 0,
				time:'请选择',
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl,
				addressName:"请先添加联系人",
				addressTel:"手机号",
				addressLocation:"请先添加地址",
				addressId:0,
				addressList: []
			}
		},
		components: {
			uniNavBar,
			popupLayer
		},
		methods: {
			toBack: function() {
				uni.navigateBack({
					delta: 1
				})
			},
			showMaintain: function() {
				uni.showToast({
					title: '该功能维护中',
					icon: 'none'
				})
			},
			toDaelitime: function(){
				uni.navigateTo({
					url:'deliverytime'
				})
			},
			showPopup:function(){
				this.$refs.popupRef.show()
			},
			rowClick:function(row){
				// 选择地址
				this.addressName = row.addressName
				this.addressTel = row.addressPhone
				this.addressLocation = row.addressInfo + ' ' + row.addressDetail
				this.addressId = row.addressId
				// 关闭popup
				this.$refs.popupRef.close()
			},
			subOrder:function(){
				//处理carId
				let carIds = this.carInfomation[0].carId
				for(let i=1;i<this.carInfomation.length;i++){
					carIds = carIds + '?' + this.carInfomation[i].carId 
				}
				// 验证
				if(this.time=='请选择'){
					uni.showToast({
						title:'请选择配送时间',
						icon:'none'
					})
					return
				}
				if(this.addressId==0){
					uni.showToast({
						title:'请选择配送地址',
						icon:'none'
					})
					return
				}
				// 添加数据
				let data = {
					orderCarid : carIds,
					orderUserid : this.$User.user.userId,
					orderDeliverytime : this.time,
					orderPrice : this.price,
					orderDiscount : 0,
					orderAddressid : this.addressId,
				}
				//向服务器提交订单
				uni.showLoading({
					title:'正在提交订单...'
				})
				uni.request({
					url:this.httpDataUrl + '/cakeOrder/addCakeOrderInfo',
					data:data,
					success: (res) => {
						if(res.data.code==0){
							//提交成功
							//console.log(res)
							//传入订单全局变量
							this.$Order.addOrder(res.data.data[0])
							uni.hideLoading();
							uni.redirectTo({
								url:'payment?amount='+(parseInt(this.price)+parseInt(30))+'&orderName='+res.data.data[0].orderNo
							})
						}
					}
				})
				//跳转到支付页面
				//商品列表
				// if(paymentOrder.length==0){
				// 	uni.showToast({title:'订单信息有误，请重新购买',icon:'none'});
				// 	return ;
				// }
			}
		},
		onLoad() {
			this.carInfomation = this.$cakeCar.car
			//console.log(this.carInfomation)
			let cakePrice = 0
			let cakeNum = 0
			for (let i = 0; i < this.carInfomation.length; i++) {
				//计算数量
				cakeNum = cakeNum + parseInt(this.carInfomation[i].carNum);
				//计算价格
				cakePrice = cakePrice + parseInt(this.carInfomation[i].cakeSpecsList[0].cakespecsPrice) * parseInt(this.carInfomation[i].carNum)
			}
			this.num = cakeNum
			this.price = cakePrice
			//console.log(this.carInfomation)
			
			//向服务器获取地址
			uni.request({
				url:this.httpDataUrl + '/address/getAllAddressByUserId?addressUserid='+this.$User.user.userId,
				success: (res) => {
					console.log(res)
					if(res.data.code==0){
						// 获取到地址
						this.addressList = res.data.data
						this.addressName = res.data.data[0].addressName
						this.addressTel = res.data.data[0].addressPhone
						this.addressLocation = res.data.data[0].addressInfo + ' ' + res.data.data[0].addressDetail
						this.addressId = res.data.data[0].addressId
					}
				}
			})
		}
	}
</script>

<style lang="scss">
	/* 用户信息 */
	.item_card {
		border-top: 6px solid #F4F4F4;
		width: 100%;
		box-sizing: border-box;
		padding: 35upx;
		position: relative;
	}

	.form_card {
		width: 100%;
		border-top: 6px solid #F4F4F4;
		box-sizing: border-box;
		padding: 0 35upx;
	}

	.user_infomation_box {
		box-sizing: border-box;
		padding: 45upx;
		background-image: url('../../static/boder.png');
		background-size: 100% 100%;
		background-repeat: no-repeat;
	}

	.user_infomation_box view {
		font-size: 32upx;
		margin-bottom: 30upx;
	}

	.user_infomation_box view:nth-child(3) {
		margin-bottom: 0upx;
	}
	
	.cangeAddress{
		position: absolute;
		top: 70upx;
		right: 70upx;
		font-size: 24upx !important;
		color: #25E0E4;
	}

	/* 表单填写 */
	.form_item {
		overflow: hidden;
		border-bottom: 1px solid #F4F4F4;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		box-sizing: border-box;
		padding: 20upx 0;
	}

	.cake_information .form_item:last-child {
		border-bottom: none;
	}

	.form_item .item_left {}

	.form_item .item_left .left_text {
		font-size: 32upx;
	}

	.form_item .item_left .image {
		display: inline-block;
		height: 120upx;
		width: 120upx;
		margin-right: 20upx;
		background-size: 100% auto;
		background-position: center;
		background-repeat: no-repeat;
	}

	.form_item .item_right {
		display: flex;
	}

	.form_item .item_right .item_content {
		display: inline-block;
		font-size: 24upx;
		color: #CCCCCC;
		height: 100%;
	}

	.form_item .item_right .item_content::before {
		display: inline-block;
		content: "";
		height: 100%;
		vertical-align: middle;
	}

	.form_item .item_right span {
		display: inline-block;
		width: 48upx;
		height: 100%;
		margin-left: 20upx;
		background-image: url(../../static/toRight.png);
		background-size: 48upx 48upx;
		background-repeat: no-repeat;
		background-position: center;
	}

	/* 结算 */
	.price_box {
		width: 100%;
		overflow: hidden;
		box-sizing: border-box;
		padding: 0 35upx;
	}

	.price_box view {
		overflow: hidden;
	}

	.price_box view text {
		float: right;
		font-size: 32upx;
		display: inline-block;
		margin-left: 15upx;
		margin-top: 15upx;
	}

	.price_box view .title {
		width: 100upx;
	}

	.price_box view .price {
		width: 150upx;
		color: #FF1850;
	}


	/* 去支付 */
	.settlement_box {
		width: 100%;
		height: 100upx;
		background: #FFFFFF;
		position: fixed;
		/* bottom: 50px; */
		bottom: 0px;
		overflow: hidden;
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
	
	
	/* 地址选择 */
	.list view {
		display: flex;
	}

	.icon {
		&.bianji {
			background-image: url('../../static/edit.png');
			background-size: auto 100%;
			background-repeat: no-repeat;
			background-position: center;
		}
		// &.tianjia {
		// 	&:before{content:"\e81a";}
		// }
	}

	.add {
		position: fixed;
		bottom: 0;
		width: 100%;
		height: 120upx;
		justify-content: center;
		align-items: center;

		.btn {
			box-shadow: 0upx 5upx 10upx rgba(0, 0, 0, 0.4);
			width: 70%;
			height: 80upx;
			border-radius: 80upx;
			background: linear-gradient(to left, #FE7196, #FF1850);
			color: #fff;
			justify-content: center;
			align-items: center;

			.icon {
				height: 80upx;
				color: #fff;
				font-size: 30upx;
				justify-content: center;
				align-items: center;
			}

			font-size: 30upx;
		}
	}

	.list {
		flex-wrap: wrap;
		padding: 20upx;
		box-sizing: border-box;
		.row {
			width: 96%;
			padding: 20upx 2%;
			border-bottom: #F4F4F4 1px solid;
			.left {
				width: 90upx;
				flex-shrink: 0;
				align-items: center;

				.head {
					width: 70upx;
					height: 70upx;
					background: linear-gradient(to right, #ccc, #aaa);
					color: #fff;
					justify-content: center;
					align-items: center;
					border-radius: 60upx;
					font-size: 35upx;
				}
			}

			.center {
				width: 100%;
				flex-wrap: wrap;

				.name-tel {
					width: 100%;
					align-items: baseline;

					.name {
						font-size: 34upx;
					}

					.tel {
						margin-left: 30upx;
						font-size: 24upx;
						color: #777;
					}

					.default {
						font-size: 22upx;
						background: linear-gradient(to left, #FE7196, #FF1850);
						color: #fff;
						padding: 0 18upx;
						border-radius: 24upx;
						margin-left: 20upx;
					}
				}

				.address {
					width: 100%;
					font-size: 24upx;
					align-items: baseline;
					color: #777;
				}
			}

			.right {
				flex-shrink: 0;
				align-items: center;
				margin-left: 20upx;

				.icon {
					justify-content: center;
					align-items: center;
					width: 80upx;
					height: 60upx;
					border-left: solid 1upx #aaa;
					font-size: 40upx;
					color: #777;
				}
			}
		}
	}
	.fill {
		height: 120upx;
	}
</style>
