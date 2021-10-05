<template>
	<view>
		<view class="logo_wapper">
			<image src="../../static/logo.png" mode=""></image>
		</view>
		<view class="login_form">
			<view class="form_input">
				<!-- 用户名 -->
				<input type="text" name="username" id="username" placeholder="请输入手机号" v-model="username">
			</view>
			<view class="form_input v_code_input" v-if="isVcode">
				<!-- 验证码 -->
				<input type="text" name="verificationcode" id="verificationcode" placeholder="请输入验证码" v-model="verificationcode">
				<vcodebtn :phone="username" flag="0"></vcodebtn>
			</view>
			<view class="form_input" v-if="isPwd">
				<!-- 密码 -->
				<input type="password" name="password" id="password" placeholder="请输入密码" v-model="password">
			</view>
			<view class="func_btn_wapper">
				<view v-on:click="toPwd">
					{{transformationBtnData}}
				</view>
				<view v-on:click="toReg">
					注册账号
				</view>
			</view>
			<view class="login_submit" v-on:click="login">登录</view>
		</view>
	</view>
</template>

<script>
	import vcodebtn from "../../components/my-components/vcodebtn.vue"
	export default {
		data() {
			return {
				isVcode: false,
				isPwd: true,
				content: '发送验证码',
				totalTime: 10,
				canClick: true, //添加canClick
				transformationBtnData: '手机号登录',
				// 表单字段
				username: '',
				verificationcode: '',
				password: ''
			}
		},
		onLoad() {

		},
		methods: {
			toPwd: function(e) {
				if (this.isVcode) {
					this.isVcode = false
					this.isPwd = true
					this.transformationBtnData = '手机号登录'
					return null
				}
				if (this.isPwd) {
					this.isPwd = false
					this.isVcode = true
					this.transformationBtnData = '密码登录'
					return null
				}
			},
			toReg: function() {
				uni.navigateTo({
					url: "register"
				})
			},
			login: function(e) {
				//判断是否输入手机号
				if(this.username==''||this.username==null){
					uni.showToast({
						icon: 'none',
						title: '请输入手机号'
					});
					return null
				}
				if (this.isVcode) {
					console.log("这是验证码登录")
					console.log(this.username + '/' + this.verificationcode)
					//判断是否输入验证码
					if(this.verificationcode==''||this.verificationcode==null){
						uni.showToast({
							icon: 'none',
							title: '请输入验证码'
						});
						return null
					}
					//ajax请求
					uni.request({
						url: "http://www.reloss.top:8888/bsk/loginByPhone",
						data: {
							sessionid: this.$User.session,
							userPhone: this.username,
							code: this.verificationcode
						},
						success: (res) => {
							console.log(res)
							//console.log(res.data.code==1)
							if (res.data.code == 1) {
								//console.log("111")
								uni.showToast({
									title: res.data.msg,
									icon: 'none'
								})
							} else {
								//console.log("122222")
								//将用户信息储存到全局变量里
								this.$User.addUser(res.data.data[0])
								this.$User.addSession(res.data.session)
								uni.navigateBack({
									delta:1
								})
							}
						}
					})
					return null
				}
				if (this.isPwd) {
					console.log("这是密码登录")
					console.log(this.username + '/' + this.password)
					//判断是否输入密码
					if(this.password==''||this.password==null){
						uni.showToast({
							icon: 'none',
							title: '请输入密码'
						});
						return null
					}
					//ajax请求
					uni.request({
						url: "http://www.reloss.top:8888/bsk/loginByPwd",
						data: {
							userPhone: this.username,
							userPwd: this.password
						},
						success: (res) => {
							console.log(res)
							if (res.data.code == 1) {
								//console.log("222")
								uni.showToast({
									title: res.data.msg,
									icon: 'none'
								})
							} else {
								this.$User.addUser(res.data.data[0])
								this.$User.addSession(res.data.session)
								uni.navigateBack({
									delta:1
								})
							}
						}
					})
					return null
				}
			}
		},
		components: {
			vcodebtn
		}
	}
</script>

<style>
	@import "../../common/login.css";
</style>
