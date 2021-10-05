<template>
	<view>
		<view class="content">
			<view class="row">
				<view class="nominal">
					收件人
				</view>
				<view class="input">
					<input placeholder="请输入收件人姓名" type="text" v-model="name"/>
				</view>
			</view>
			<view class="row">
				<view class="nominal">
					电话号码
				</view>
				<view class="input">
					<input placeholder="请输入收件人电话号码" type="text" v-model="tel" />
				</view>
			</view>
			<view class="row">
				<view class="nominal">
					所在地区
				</view>
				<view class="input" @tap="chooseCity">
					{{cityPickerValue}}
				</view>

			</view>
			<view class="row">
				<view class="nominal">
					详细地址
				</view>
				<view class="input">
					<textarea v-model="detailed" auto-height="true" placeholder="输入详细地址"></textarea>
				</view>
			</view>
			<view class="row">
				<view class="nominal">
					设置默认地址
				</view>
				<view class="input switch">
					<switch color="#FF1850" :checked="isDefault" @change='isDefaultChange' />
				</view>
			</view>
			<view class="row" v-if="editType=='edit'" @tap="del">
				<view class="del">
					删除收货地址
				</view>
			</view>
		</view>
		<view class="save" @tap="save">
			<view class="btn">
				保存地址
			</view>
		</view>
		<mpvue-city-picker :themeColor="themeColor" ref="mpvueCityPicker" @onCancel="onCancel"
		 @onConfirm="onConfirm"></mpvue-city-picker>
	</view>
</template>

<script>
	import mpvueCityPicker from '@/components/mpvue-citypicker/mpvueCityPicker.vue'
	export default {
		components: {
			mpvueCityPicker
		},
		data() {
			return {
				editType: 'edit',
				id: '',
				name: '',
				tel: '',
				detailed: '',
				isDefault: false,
				themeColor: '#007AFF',
				cityPickerValue: '',
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl
			};
		},
		methods: {
			onCancel(e) {
				console.log(e)
			},
			chooseCity() {
				this.$refs.mpvueCityPicker.show()
			},
			onConfirm(e) {
				this.cityPickerValue = e.label;
			},
			isDefaultChange(e) {
				this.isDefault = e.detail.value;
			},
			del() {
				uni.showModal({
					title: '删除提示',
					content: '你将删除这个收货地址',
					success: (res) => {
						if (res.confirm) {
							uni.request({
								url:this.httpDataUrl + '/address/removeAddress?addressId=' + this.id,
								success: (res) => {
									if(res.data.code == 0){
										uni.navigateBack();
									}
								}
							})
							// uni.setStorage({
							// 	key: 'delAddress',
							// 	data: {
							// 		id: this.id
							// 	},
							// 	success() {
							// 		uni.navigateBack();
							// 	}
							// })
						} else if (res.cancel) {
							console.log('用户点击取消');
						}
					}
				});

			},
			save() {
				let data = {
					"addressId":"",
					"addressName": this.name,
					"addressPhone": this.tel,
					"addressInfo":this.cityPickerValue + '?' + this.detailed
				}
				if (this.editType == 'edit') {
					data.addressId = this.id
				}
				if (!data.addressName) {
					uni.showToast({
						title: '请输入收件人姓名',
						icon: 'none'
					});
					return;
				}
				if (!data.addressPhone) {
					uni.showToast({
						title: '请输入收件人电话号码',
						icon: 'none'
					});
					return;
				}
				if (!data.addressInfo) {
					uni.showToast({
						title: '请输入收件人详细地址',
						icon: 'none'
					});
					return;
				}
				uni.showLoading({
					title: '正在提交'
				})
				//实际应用中请提交ajax,模板定时器模拟提交效果
				// setTimeout(() => {
				// 	uni.setStorage({
				// 		key: 'saveAddress',
				// 		data: data,
				// 		success() {
				// 			uni.hideLoading();
				// 			uni.navigateBack();
				// 		}
				// 	})
				// }, 300)
				//ajax
				if (this.editType == 'edit') {
					//修改
					uni.request({
						url:this.httpDataUrl + '/address/editAddress',
						data:data,
						success: (res) => {
							if(res.data.code==0){
								uni.hideLoading();
								uni.navigateBack();
							}
						}
					})
				}
				if(this.editType == 'add') {
					//添加
					data.addressUserid = this.$User.user.userId
					uni.request({
						url:this.httpDataUrl + '/address/addAddress',
						data:data,
						success: (res) => {
							if(res.data.code==0){
								uni.hideLoading();
								uni.navigateBack();
							}
						}
					})
				}
			}
		},
		onLoad(e) {
			//获取传递过来的参数
			this.editType = e.type;
			if (e.type == 'edit') {
				uni.getStorage({
					key: 'address',
					success: (e) => {
						this.id = e.data.addressId;
						this.name = e.data.addressName;
						this.tel = e.data.addressPhone;
						this.detailed = e.data.addressDetail;
						this.isDefault = e.data.isDefault;
						this.cityPickerValue = e.data.addressInfo;
					}
				})
			}

		},
		onBackPress() {
			if (this.$refs.mpvueCityPicker.showPicker) {
				this.$refs.mpvueCityPicker.pickerCancel();
				return true;
			}
		},
		onUnload() {
			if (this.$refs.mpvueCityPicker.showPicker) {
				this.$refs.mpvueCityPicker.pickerCancel()
			}
		}
	};
</script>
<style lang="scss">
	.input input,.input textarea{
		font-size: 30upx;
	}
	
	.save {
		view {
			display: flex;
			font-size: 24upx;
		}

		position: fixed;
		bottom: 0;
		width: 100%;
		height: 120upx;
		display: flex;
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
				// font-size: 30upx;
				justify-content: center;
				align-items: center;
			}

			font-size: 24upx;
		}
	}

	.content {
		display: flex;
		flex-wrap: wrap;

		view {
			display: flex;
		}

		.row {
			width: 94%;

			margin: 0 3%;
			border-top: solid 1upx #eee;

			.nominal {
				width: 30%;
				height: 120upx;
				font-weight: 200;
				font-size: 24upx;
				align-items: center;
			}

			.input {
				width: 70%;
				padding: 20upx 0;
				align-items: center;
				font-size: 24upx;

				&.switch {
					justify-content: flex-end;
				}

				.textarea {
					margin: 20upx 0;
					min-height: 120upx;
				}
			}

			.del {
				width: 100%;
				height: 100upx;
				justify-content: center;
				align-items: center;
				font-size: 36upx;
				color: #FF1850;
				background-color: rgba(255, 0, 0, 0.05);
				border-bottom: solid 1upx #eee;
			}
		}
	}
</style>
