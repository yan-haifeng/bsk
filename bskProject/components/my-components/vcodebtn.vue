<template>
	<view>
		<view class="get_code_btn" v-on:click="getcode">{{content}}</view>
	</view>
</template>

<script>
	export default {
		props:{
			phone : {
				type : String,
				default : "0"
			},
			flag : {
				type : String,
				default : ""
			}
		},
		data() {
			return{
				httpDataUrl: this.$httpUrl.dataUrl,
				content: '发送验证码',
				totalTime: 60,
				canClick: true, //添加canClick
			};
		},
		methods:{
			getcode: function() {
				console.log(this.phone)
				if(this.phone==''||this.phone==null){
					uni.showToast({
						icon: 'none',
						title: '请输入手机号'
					});
					return null
				}
				//验证码动画
				if (!this.canClick) return //改动的是这两行代码
				// ajax 请求
				uni.request({
					url: this.httpDataUrl+"/getPhoneCode",
					data:{
						select:this.flag,
						phoneNum: this.phone
					},
					success: (res) => {
						console.log(res.data.msg)
						if(res.data.code==0){
							this.totalTime = 60
							this.$User.addSession(res.data.session)
						} else {
							this.totalTime = 10
						}
						uni.showToast({
							icon: 'none',
							title: res.data.msg
						});
					}
				})
				// ajax 请求
				// 验证码实现后删除
				// uni.showToast({
				// 	title:'手机验证码是0！！！',
				// 	icon:'none'
				// })
				// 验证码实现后删除
				// 验证码动画开始
				this.canClick = false
				this.content = this.totalTime + 's后重新发送'
				let clock = setInterval(() => {
					this.totalTime--
					this.content = this.totalTime + 's后重新发送'
					if (this.totalTime < 0) {
						clearInterval(clock)
						this.content = '重新发送验证码'
						this.totalTime = 10
						this.canClick = true //这里重新开启
					}
				}, 1000)
			}
		}
	}
</script>

<style>
.get_code_btn {
 	width: 35%;
 	height: 50rpx;
 	margin-bottom: 10rpx;
 	border-radius: 40rpx;
 	background: linear-gradient(to right, #FE7196, #FF1850);
 	color: #fff;
 	float: right;
 	line-height: 50rpx;
 	text-align: center;
 	font-size: 24rpx;
 	transform: translate(0,  25%);
 	box-shadow: 6rpx 6rpx 20rpx #FE7196;
 }
</style>
