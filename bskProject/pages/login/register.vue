<template>
	<view class="body">
		<view class="login_form">
			<view class="form_input">
				<!-- 用户名 -->
				<input type="text" name="username" id="username" placeholder="请输入手机号" v-model="username">
			</view>
			<view class="form_input v_code_input">
				<!-- 验证码 -->
				<input type="text" name="verificationcode" id="verificationcode" placeholder="请输入验证码" v-model="verificationcode">
				<vcodebtn :phone="username" flag="1"></vcodebtn>
			</view>
			<view class="form_input">
				<!-- 密码 -->
				<input type="password" name="password" id="password" placeholder="请输入密码" v-model="password">
			</view>
			<view class="form_input">
				<!-- 密码 -->
				<input type="password" name="aginpassword" id="aginpassword" placeholder="请再次输入密码" v-model="againpassword">
			</view>
			<view class="login_submit" v-on:click="register">注册</view>
		</view>
	</view>
</template>

<script>
	import vcodebtn from "../../components/my-components/vcodebtn.vue"
	export default {
		data() {
			return {
				username: '',
				verificationcode: '',
				password: '',
				againpassword: ''
			}
		},
		methods: {
			register: function(e) {
				//判断密码是否一致
				if (!(this.password == this.againpassword)) {
					uni.showToast({
						icon: 'none',
						title: '两次密码不正确'
					});
					//console.log("两次密码不一样") 
					return null
				}
				//console.log(this.username + '/' + this.verificationcode + '/' + this.password + '/' + this.againpassword)
				//判断是否提交空值
				if(this.username==''||this.username==null){
					uni.showToast({
						icon: 'none',
						title: '请输入手机号'
					});
					return null
				}
				if(this.verificationcode==''||this.verificationcode==null){
					uni.showToast({
						icon: 'none',
						title: '请输入验证码'
					});
					return null
				}
				if(this.password==''||this.password==null){
					uni.showToast({
						icon: 'none',
						title: '请输入密码'
					});
					return null
				}
				//ajax请求
				uni.request({
					url: "http://www.reloss.top:8888/bsk/register",
					data: {
						sessionid: this.$User.session,
						userPhone: this.username,
						userPwd: this.password,
						code: this.verificationcode
					},
					success: (res) => {
						console.log(res)
						if (res.data.code == 1) {
							console.log("111")
							uni.showToast({
								title: res.data.msg,
								icon: 'none'
							})
						} else {
							uni.showToast({
								title: res.data.msg,
								icon: 'none'
							})
							setTimeout(function(){
								uni.navigateBack({
									delta:1
								})
							},500)
							
						}
					}
				})
			}
		},
		components: {
			vcodebtn
		}
	}
</script>

<style>
	@import "../../common/login.css";

	.login_form {
		margin-top: -250rpx;
	}

	.body {
		border-top: 10rpx solid #F9F9F9;
	}
</style>
