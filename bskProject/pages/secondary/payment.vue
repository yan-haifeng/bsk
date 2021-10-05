<template>
	<view>
		<view class="block">
			<view class="content">
				<view class="orderinfo">
					<view class="row">
						<view class="nominal">订单名称:</view>
						<view class="text">{{orderName}}</view>
					</view>
					<view class="row">
						<view class="nominal">订单金额:</view>
						<view class="text">{{amount}}元</view>
					</view>
				</view>
			</view>
		</view>
		<view class="block">
			<view class="title">
				选择支付方式
			</view>
			<view class="content">
				<view class="pay-list">
					<view class="row" @tap="paytype='alipay'">
						<view class="left">
							<image src="../../static/alipay.png"></image>
						</view>
						<view class="center">
							支付宝支付
						</view>
						<view class="right">
							<radio :checked="paytype=='alipay'" color="#FF1850" />
						</view>
					</view>
					<view class="row" @tap="paytype='wxpay'">
						<view class="left">
							<image src="../../static/wxpay.png"></image>
						</view>
						<view class="center">
							微信支付
						</view>
						<view class="right">
							<radio :checked="paytype=='wxpay'" color="#FF1850" />
						</view>
					</view>
				</view>
			</view>
		</view>
		<view class="pay">
			<view class="btn" @tap="doDeposit">立即支付</view>
			<view class="tis">
				点击立即支付，即代表您同意<view class="terms">
					《条款协议》
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				amount: 0,
				orderName: '',
				paytype: 'alipay', //支付类型
				// orderInfo:'',
				isPay:false
			};
		},
		onShow() {
			//判断支付成功还是失败
			this.isPays()
		},
		onLoad(e) {
			this.amount = parseFloat(e.amount).toFixed(2);
			this.orderName = e.orderName
			this.isPay = false
			// this.orderInfo = e.orderInfo
			// uni.getStorage({
			// 	key: 'paymentOrder',
			// 	success: (e) => {
			// 		if (e.data.length > 1) {
			// 			this.orderName = '多商品合并支付'
			// 		} else {
			// 			this.orderName = e.data[0].name;
			// 		}
			// 		uni.removeStorage({
			// 			key: 'paymentOrder'
			// 		})
			// 	}
			// })
			console.log(this.$Order.order)
		},
		methods: {
			doDeposit() {
				// console.log(this.paytype == 'wxpay')
				// console.log(this.paytype)
				// 微信支付暂不能使用
				if (this.paytype == 'wxpay') {
					uni.showToast({
						title: '微信支付暂不能使用',
						icon: 'none'
					})
					return
				}
				// 微信支付暂不能使用
				if (this.paytype == 'alipay') {
					//模板模拟支付，实际应用请调起微信/支付宝
					// uni.showLoading({
					// 	title: '支付中...'
					// });
					this.isPay = true
					// 跳到支付页面
					uni.navigateTo({
						url:'web-view?orderInfo = ' + this.orderInfo
					})
					// setTimeout(() => {
					// 	uni.hideLoading();
					// 	uni.showToast({
					// 		title: '支付成功'
					// 	});
					// 	setTimeout(() => {
					// 		uni.redirectTo({
					// 			url: 'success?amount=' + this.amount
					// 		});
					// 	}, 300);
					// }, 700)
				}
			},
			isPays(){
				if(this.isPay){
					uni.showToast({
						title:'支付失败，请重新支付',
						icon:'none'
					})
					uni.redirectTo({
						url:'fail'
					})
				}
			}
		}
	}
</script>

<style lang="scss">
	.block {
		width: 94%;
		padding: 0 3% 40upx 3%;

		.title {
			width: 100%;
			font-size: 34upx;
		}

		.content {
			.orderinfo {
				width: 100%;
				border-bottom: solid 1upx #eee;

				.row {
					width: 100%;
					height: 90upx;
					display: flex;
					align-items: center;

					.nominal {
						flex-shrink: 0;
						font-size: 32upx;
						color: #7d7d7d;
					}

					.text {
						width: 70%;
						margin-left: 10upx;
						overflow: hidden;
						text-overflow: ellipsis;
						white-space: nowrap;
						font-size: 32upx;
					}
				}
			}

			.pay-list {
				width: 100%;
				border-bottom: solid 1upx #eee;

				.row {
					width: 100%;
					height: 120upx;
					display: flex;
					align-items: center;

					.left {
						width: 100upx;
						flex-shrink: 0;
						display: flex;
						align-items: center;

						image {
							width: 80upx;
							height: 80upx;
						}
					}

					.center {
						width: 100%;
						font-size: 30upx;
					}

					.right {
						width: 100upx;
						flex-shrink: 0;
						display: flex;
						justify-content: flex-end;
					}
				}
			}
		}
	}

	.pay {
		margin-top: 20upx;
		width: 100%;
		display: flex;
		justify-content: center;
		flex-wrap: wrap;

		.btn {
			width: 70%;
			height: 80upx;
			border-radius: 80upx;
			display: flex;
			justify-content: center;
			align-items: center;
			color: #fff;
			background: linear-gradient(to left, #FE7196, #FF1850);
			box-shadow: 0upx 5upx 10upx rgba(0, 0, 0, 0.2);
		}

		.tis {
			margin-top: 10upx;
			width: 100%;
			font-size: 24upx;
			display: flex;
			justify-content: center;
			align-items: baseline;
			color: #999;

			.terms {
				color: #5a9ef7;
			}
		}
	}
</style>
