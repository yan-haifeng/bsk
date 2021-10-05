<template>
	<view>
		<uni-nav-bar id="header" title="我的" backgroundColor="rgba(255,255,255,0)" color="#FFFFFF" paddingTop="20px">
			<!-- borderTop="20px solid #FF6284" -->
			<view slot="right">
				<image src="../../static/setting.png" style="width: 50upx; height: 50upx; display: block; margin: auto;" mode="widthFix"></image>
			</view>	
		</uni-nav-bar>
		<!-- 导航栏下所有 -->
		<!-- 背景图片 -->
		<view class="bgTop" style=""></view>
		<view class="bgBox" style="background: #fff;width: 100%;">
			<!-- 所有用户信息内容 -->
			<scroll-view scroll-y="true">
				<view style="width: 100%;">
					<view class="userBox" style="">
						<view class="userImg">
							<image src="../../static/userImg.png" mode="" style=""></image>
						</view>
						<!-- 未登录 -->
						<view class="userInfo" @tap="toLogin" v-if="!isLogin">
							<view class="userName">点击登录</view>
							<view class="userNameE">WEST CLEORATON</view>
							<view>
								<image src="../../static/rank_strip.png" mode=""></image>
							</view>
							<view class="userRank"><text>LV.1</text><text>LV.2</text></view>
						</view>
						<!-- 登录后 -->
						<view class="userInfo" v-if="isLogin">
							<view class="userName" @tap="notDoIt">{{userName}}</view>
							<view class="userNameE">WEST CLEORATON</view>
							<view>
								<image src="../../static/rank_strip.png" mode=""></image>
							</view>
							<view class="userRank"><text>LV.1</text><text>LV.2</text></view>
						</view>
						<view class="userRankImg">
							<image src="../../static/rankImg.png" mode=""></image>
						</view>
					</view>
					<view style="background: #FFFFFF;">
						<view class="myOrderBox">
							<view class="myText">
								我的订单
							</view>
							<ul>
								<li @tap="notDoIt">
									<span class="payment"></span>
									<text>待付款</text>
								</li>
								<li @tap="notDoIt">
									<span class="receipt"></span>
									<text>待收货</text>
								</li>
								<li @tap="notDoIt">
									<span class="evaluation"></span>
									<text>待评价</text>
								</li>
								<li @tap="notDoIt">
									<span class="customer"></span>
									<text>客服</text>
								</li>
							</ul>
						</view>
						<view class="myWalletBox">
							<view class="myText">
								我的钱包
							</view>
							<ul>
								<li @tap="notDoIt">
									<view>
										<text>0</text><text>个</text>
									</view>
									<text>待付款</text>
								</li>
								<li @tap="notDoIt">
									<view>
										<text>0</text><text>张</text>
									</view>
									<text>兑换券</text>
								</li>
								<li @tap="notDoIt">
									<view>
										<text>0</text><text>张</text>
									</view>
									<text>优惠券</text>
								</li>
							</ul>
						</view>
						<view class="mySettingBox">
							<ul>
								<li>
									<view class="mySettingLine" @tap="toAddress">
										<image class="settingImgPre" src="../../static/location_me.png" mode=""></image>
										<text>地址管理</text>
										<image class="settingImgSuf" src="../../static/toRight.png" mode=""></image>
									</view>
								</li>
								<li>
									<view class="mySettingLine" @tap="about_bsk">
										<image class="settingImgPre" src="../../static/about_me.png" mode=""></image>
										<text>关于</text>
										<image class="settingImgSuf" src="../../static/toRight.png" mode=""></image>
									</view>
								</li>
								<li>
									<view class="mySettingLine" v-if="isLogin" @tap="quitLogin">
										<image class="settingImgPre" src="../../static/quit_me.png" mode=""></image>
										<text>退出</text>
										<image class="settingImgSuf" src="../../static/toRight.png" mode=""></image>
									</view>
								</li>
								<!-- <view class="" style="height: 1000px;">
								</view> -->
							</ul>
						</view>
					</view>
				</view>
			</scroll-view>
		</view>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue";
	export default {
		data() {
			return {
				isLogin:false,
				userName:"你好！贝思客新用户，点击我改名哟",
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl
			}
		},
		components: {
			uniNavBar
		},
		methods: {
			toLogin: function() {
				//登录
				uni.navigateTo({
					url: '../login/login'
				})
			},
			quitLogin:function(){
				//退出登录
				uni.request({
					url:this.httpDataUrl+'/quitLogin',
					data:{
						sessionid: this.$User.session
					},
					success: (res) => {
						if(res.data.code==0){
							//退出成功
							uni.showToast({
								title:'退出成功',
								icon:'none'
							})
							this.pageOnShow()
						}
					}
				})
			},
			toAddress:function(){
				//地址管理
				//判断用户是否登录
				uni.request({
					url:this.httpDataUrl+'/isLogin',
					data:{
						sessionid: this.$User.session
					},
					success: (res) => {
						console.log(res)
						if(res.data.code==1){
							//未登录
							uni.showToast({
								title:'先去登录哟！',
								icon:'none'
							})
						}
						if(res.data.code==0){
							//用户已登录，跳转页面
							uni.navigateTo({
								url:'../secondary/address'
							})
						}
					}
				})
			},
			pageOnShow(){
				//向服务器获取是否登录
				uni.request({
					url:this.httpDataUrl+'/isLogin',
					data:{
						sessionid: this.$User.session
					},
					success: (res) => {
						//console.log(res)
						if(res.data.code==1){
							//未登录
							this.isLogin = false
						}
						if(res.data.code==0){
							//已登录 
							this.isLogin = true
							//向全局变量添加登录用户信息
							this.$User.addUser(res.data.data[0])
							//改变用户名变量
							if(this.$User.user.userName!=null){
								this.userName = this.$User.user.userName
							}
						}
					}
				})
			},
			notDoIt:function(){
				uni.showToast({
					title:'该功能完善中，敬请期待',
					icon:'none'
				})
			},
			about_bsk:function(){
				uni.showToast({
					title:'当前版本 0.6.66',
					icon:'none'
				})
			}
		},
		onLoad() {
			setTimeout(function() {
				console.log('start pulldown');
			}, 1000);
			uni.startPullDownRefresh();
		},
		onPullDownRefresh() {
			console.log("onPullDownRefresh 下拉刷新: ")
			console.log('refresh');
			setTimeout(function() {
				uni.stopPullDownRefresh();
			}, 1000);
		},
		onShow() {
			this.pageOnShow()
		}
	}
</script>

<style>
	.userBox {
		display: flex;
		margin: 40upx 20upx;
		padding: 20upx;
		background: #FFFFFF;
		border-radius: 20upx;
		box-shadow: 2px 2px 10px #cccccc;
		overflow: hidden;
	}

	.userImg {
		padding: 10upx 20upx;
		flex: 2;
	}

	.userImg image {
		width: 150upx;
		height: 150upx;
		border-radius: 50px;
	}

	/* 背景图片 */
	.bgTop {
		position: fixed;
		top: 0upx;
		background-image: url('../../static/backgroud_me.png');
		background-position: 0 -22upx;
		background-size: 100% auto;
		width: 100%;
		height: 300upx;
		z-index: 0;
	}

	.userBox .userInfo {
		flex: 4;
		margin: 10upx 0;
		font-size: 28upx;
	}

	.userInfo .userName {
		font-size: 36upx;
		font-weight: bold;
		color: #333;
		margin-bottom: 10upx;
		margin-top: 5upx;
	}

	.userInfo .userNameE {
		font-size: 20upx;
		color: #CCCCCC;
	}

	.userInfo .userRank {
		display: flex;
		flex-direction: row;
	}

	.userInfo .userRank text {
		font-size: 20upx;
		color: #CCCCCC;
	}

	.userInfo .userRank text:nth-child(1) {
		flex: 1;
		text-align: left;
	}

	.userInfo .userRank text:nth-child(2) {
		flex: 1;
		text-align: right;
	}

	.userInfo image {
		width: 100%;
		height: 10upx;
	}

	.userBox .userRankImg {
		padding: 10upx;
		flex: 1;
	}

	.userBox .userRankImg image {
		margin-left: 20upx;
		width: 70upx;
		height: 100upx;
	}

	.myOrderBox {
		margin: 40upx 20upx 10upx 20upx;
		padding: 10upx;
	}

	.myText {
		font-size: 36upx;
		font-weight: bold;
	}

	.myOrderBox ul {
		display: flex;
		margin: 15upx 0;
		padding: 30upx 0;
		border-top: 1px solid #DDDDDD;
		flex-direction: row;
		box-sizing: border-box;
		padding-bottom: 0px;
	}

	.myOrderBox ul li {
		flex: 1;
		text-align: center;
		list-style: none;
	}

	.myOrderBox ul li span {
		margin: auto;
		display: block;
		width: 60upx;
		height: 60upx;
		background-size: 100% auto;
		background-repeat: no-repeat;
		margin-bottom: 10upx;
	}
	.myOrderBox ul li .payment{
		background-image: url('../../static/payment.png');
	}
	.myOrderBox ul li .receipt{
		background-image: url('../../static/receipt.png');
	}
	.myOrderBox ul li .evaluation{
		background-image: url('../../static/evaluation.png');
	}
	.myOrderBox ul li .customer{
		background-image: url('../../static/customer.png');
	}

	.myOrderBox ul li text {
		font-size: 28upx;
		color: #888888;
		display: block;
	}

	.myWalletBox {
		padding: 20upx 40upx;
		border-top: 10px solid #F9F9F9;
	}

	.myWalletBox ul {
		display: flex;
		margin: 15upx 0;
		padding: 20upx 0;
		border-top: 1px solid #DDDDDD;
		flex-direction: row;
		box-sizing: border-box;
		padding-bottom: 0px;
	}

	.myWalletBox ul li {
		flex: 1;
		text-align: center;
		list-style: none;
	}

	.myWalletBox ul li view text {
		display: inline;
	}

	.myWalletBox ul li view text:nth-child(1) {
		color: #2BE4DC;
		font-size: 40upx;
	}

	.myWalletBox ul li view text:nth-child(2) {
		color: #CCCCCC;
		font-size: 26upx;
		margin-left: 5upx;
	}

	.myWalletBox ul li text {
		font-size: 28upx;
		margin-top: 10upx;
		color: #888888;
		display: block;
	}

	.mySettingBox {
		padding: 20upx 40upx;
		border-top: 10px solid #F9F9F9;
	}

	.mySettingBox ul {
		width: 100%;
		padding: 0;
	}

	.mySettingBox ul li {
		width: 100%;
		list-style: none;
	}

	.mySettingLine {
		width: 100%;
		display: flex;
		padding: 20upx 0;
		flex-direction: row;
		border-bottom: 2px solid #F9F9F9;
	}

	.mySettingBox ul li:last-child .mySettingLine {
		border-bottom: 0;
	}

	.mySettingLine .settingImgPre {
		display: block;
		flex: 1;
		height: 55upx;
		margin-right: 20upx ;
	}

	.mySettingLine text {
		display: block;
		height: 50upx;
		line-height: 50upx;
		flex: 10;
		font-size: 30upx;
		margin-left: 10upx;
	}

	.mySettingLine .settingImgSuf {
		flex: 1;
		width: 50upx;
		height: 50upx;
	}
</style>
