<template>
	<view>
		<uni-nav-bar title="贝思客" fixed="true" paddingTop="0" borderTop="20px solid #fff">
			<view slot="left">
				<image src="../../static/location.png" style="width: 40upx; height: 40upx;position: relative; top: 8upx;margin-left: 18upx;"></image>
			</view>
			<view slot="left"><text style="font-size: 26upx;">上海</text></view>
			<view slot="right" v-on:click="search">
				<image src="../../static/search.png" style="width: 40upx; height: 40upx;position: relative; top: 10upx;"></image>
			</view>
		</uni-nav-bar>
		<mescroll-uni top="88" :down="downOption" @down="downCallback" :up="upOption" @up="upCallback" style="height: auto;">
			<swiper class="swiper" indicator-dots="true" autoplay="true" interval="5000" duration="1500">
				<swiper-item v-for="(item , index) in homeSlide" :key="index">
					<image :src="item.img" mode="aspectFill"></image>
				</swiper-item>
			</swiper>
			<view class="my-card">
				<view class="menu">
					<view class="menu-item" v-for="(item , index) in menuData" :key="index" v-on:click="menuClick(item)">
						<image :src="item.icon"></image>
						<text>{{item.text}}</text>
					</view>
				</view>
			</view>
			<view class="item-card">
				<uni-nav-bar1 style="padding: 0upx !important;width: 100%;">
					<text slot="left" class="item-title">今日折扣</text>
					<text style="font-size: 24upx; position: absolute; right: 250upx;">距离活动结束</text>
					<view slot="right" style="position: relative; right: 80upx;background: linear-gradient(to right, #FE7196, #FF1850);border-radius: 80upx; padding: 0upx 20upx; box-sizing: border-box;">
						<uni-countdown :show-day="false" :hour="12" :minute="12" :second="12" backgroundColor="transparent" color="#FFFFFF"
						 splitorColor="#FFFFFF"></uni-countdown>
					</view>
				</uni-nav-bar1>
				<cake-card-big v-for="(item,index) in DiscountToday" :key="index" v-on:PupopOpen="pupopOpen" :cake="item" :haveCheap="true"></cake-card-big>
			</view>
			<view class="item-card">
				<uni-nav-bar1 style="padding: 0upx !important;width: 100%;">
					<text slot="left" class="item-title">人气推荐</text>
				</uni-nav-bar1>
				<cake-card-big v-for="(item,index) in Popular" :key="index" :cake="item" v-on:PupopOpen="pupopOpen"></cake-card-big>
			</view>
			<view class="item-card">
				<uni-nav-bar1 style="padding: 0upx !important;width: 100%;">
					<text slot="left" class="item-title">新品推荐</text>
				</uni-nav-bar1>
				<view class="cake-card-mini-box">
					<cake-card-mini v-for="(item,index) in New" :key="index" :cake="item" v-on:PupopOpen="pupopOpen"></cake-card-mini>
				</view>
			</view>
		</mescroll-uni>
		<popup-layer ref="popupRef" :direction="'top'">
			<cake-infomation-bar ref="infomationBar" :cakeInformation="cakeinfomation" @PupopClose="pupopClose" v-if="cakeInfomationOnShow"></cake-infomation-bar>
		</popup-layer>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	import uniNavBar1 from "@/components/uni-nav-bar1/uni-nav-bar1.vue"
	import uniCountdown from "@/components/uni-countdown/uni-countdown.vue"
	import cakeCardBig from "@/components/my-components/cake-card-big.vue"
	import cakeCardMini from "@/components/my-components/cake-card-mini.vue"
	import mescrollUni from "@/components/mescroll-uni/mescroll-uni.vue"
	import cakeInfomationBar from "@/components/my-components/cake-infomation.vue"
	import popupLayer from "@/components/popup-layer/popup-layer.vue"
	export default {
		data() {
			return {
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl,
				//轮播图
				homeSlide: [{
						img: "https://res.bestcake.com/m-images/banner_list/396349397044099000.jpg"
					},
					{
						img: "https://res.bestcake.com/m-images/banner_list/366895504692554800.jpg",
					},
					{
						img: "https://res.bestcake.com/m-images/banner_list/826198420028289000.jpg"
					},
					{
						img: "https://res.bestcake.com/m-images/banner_list/27943292085256030.jpg"
					},
					{
						img: "https://res.bestcake.com/m-images/banner_new/dalibaoPc.jpg?v=2"
					}
				],
				menuData: [{
						icon: "/static/menu1.png",
						text: "生日蛋糕"
					},
					{
						icon: "/static/menu2.png",
						text: "水果蛋糕"
					},
					{
						icon: "/static/menu3.png",
						text: "慕斯蛋糕"
					},
					{
						icon: "/static/menu4.png",
						text: "巧克力蛋糕"
					}
				],
				DiscountToday: [],
				Popular: [],
				New: [],
				cakeinfomation: {},
				// 下拉刷新的常用配置
				downOption: {
					use: true, // 是否启用下拉刷新; 默认true
					auto: false, // 是否在初始化完毕之后自动执行下拉刷新的回调; 默认true
				},
				// 上拉加载的常用配置
				upOption: {
					use: true, // 是否启用上拉加载; 默认true
					auto: false, // 是否在初始化完毕之后自动执行上拉加载的回调; 默认true
					page: {
						num: 1, // 当前页码,默认0,回调之前会加1,即callback(page)会从1开始
						size: 8 // 每页数据的数量,默认10
					},
					noMoreSize: 5, // 配置列表的总数量要大于等于5条才显示'-- END --'的提示
					empty: {
						tip: '暂无相关数据'
					}
				},
				// 列表数据
				dataList: [],
				//information组件key
				cakeInfomationOnShow:false
			}
		},
		components: {
			uniNavBar,
			uniNavBar1,
			uniCountdown,
			cakeCardBig,
			cakeCardMini,
			mescrollUni,
			cakeInfomationBar,
			popupLayer
		},
		methods: {
			search: function() {
				console.log("你点了搜索")
			},
			menuClick: function(item) {
				console.log("你点了" + item.text)
				uni.showToast({
					title:'我知道你想到'+item.text+'页面，但是我就不跳，略略略',
					icon:'none'
				})
				//console.log(getApp().add(111, 222));
			},
			/*下拉刷新的回调, 有三种处理方式: */
			downCallback(mescroll) {
				//this.upOption.page.num=1
				let flag1 = false,
					flag2 = false,
					flag3 = false
				//今日折扣
				uni.request({
					url: this.httpDataUrl + "/cakeInfo/getCakeInfoByDay",
					success: (res) => {
						this.DiscountToday = res.data.data;
						flag1 = true
					},
					complete() {
						if (flag1 && flag2 && flag3) {
							setTimeout(function() {
								mescroll.endSuccess()
							}, 1000)
						}
					}
				});
				//人气推荐
				uni.request({
					url: this.httpDataUrl + "/cakeInfo/getCakeInfoByPopulity",
					success: (res) => {
						this.Popular = res.data.data;
						flag2 = true
					},
					complete() {
						if (flag1 && flag2 && flag3) {
							setTimeout(function() {
								mescroll.endSuccess()
							}, 1000)
						}
					}
				});
				//新品推荐推荐
				uni.request({
					url: this.httpDataUrl + '/cakeInfo/getAllCake?page=1&limit=8',
					success: (res) => {
						this.New = res.data.data;
						flag3 = true
					},
					complete() {
						if (flag1 && flag2 && flag3) {
							setTimeout(function() {
								mescroll.endSuccess()
							}, 1000)
						}
					}
				});

				// 第1种: 请求具体接口
				// uni.request({
				// 	url: 'xxxx',
				// 	success: () => {
				// 		// 成功隐藏下拉加载状态
				// 		setTimeout(function() {
				// 			mescroll.endSuccess()
				// 		}, 1000)

				// 	},
				// 	fail: () => {
				// 		// 失败隐藏下拉加载状态
				// 		mescroll.endErr()
				// 	}
				// })
				// 第2种: 下拉刷新和上拉加载调同样的接口, 那以上请求可删, 直接用mescroll.resetUpScroll()代替
				mescroll.resetUpScroll(); // 重置列表为第一页 (自动执行 page.num=1, 再触发upCallback方法 )
				// 第3种: 下拉刷新什么也不处理, 可直接调用或者延时一会调用 mescroll.endSuccess() 结束即可
				//mescroll.endSuccess()
			},
			/*上拉加载的回调*/
			upCallback(mescroll) {
				var that = this
				console.log("upCallback: ----start :")
				console.log(mescroll)
				// 此时mescroll会携带page的参数:
				let pageNum = mescroll.num; // 页码, 默认从1开始
				let pageSize = mescroll.size; // 页长, 默认每页10条
				setTimeout(function() {

					uni.request({
						url: that.httpDataUrl + '/cakeInfo/getAllCake?page=' + pageNum + '&limit=' + pageSize,
						success: (data) => {

							//console.log(data.data)
							// 接口返回的当前页数据列表 (数组)
							let curPageData = data.data.data;
							// 接口返回的总页数 (比如列表有26个数据,每页10条,共3页; 则totalPage值为3)
							//let totalPage = data.xxx;
							// 接口返回的总数据量(比如列表有26个数据,每页10条,共3页; 则totalSize值为26)
							let totalSize = data.data.count;
							// 接口返回的是否有下一页 (true/false)
							//let hasNext = data.xxx;

							//设置列表数据
							if (mescroll.num == 1) that.New = []; //如果是第一页需手动置空列表
							that.New = that.New.concat(curPageData); //追加新数据

							// 成功隐藏下拉加载状态
							//方法一(推荐): 后台接口有返回列表的总页数 totalPage
							//mescroll.endByPage(curPageData.length, totalPage);

							//方法二(推荐): 后台接口有返回列表的总数据量 totalSize
							mescroll.endBySize(curPageData.length, totalSize);

							//方法三(推荐): 您有其他方式知道是否有下一页 hasNext
							//mescroll.endSuccess(curPageData.length, hasNext); 

							//方法四 (不推荐),会存在一个小问题:比如列表共有20条数据,每页加载10条,共2页.
							//如果只根据当前页的数据个数判断,则需翻到第三页才会知道无更多数据
							//如果传了hasNext,则翻到第二页即可显示无更多数据.
							//mescroll.endSuccess(curPageData.length);

							// 如果数据较复杂,可等到渲染完成之后再隐藏下拉加载状态: 如
							// this.$nextTick(() => {
							// 	mescroll.endSuccess(curPageData.length)
							// })

							//curPageData.length必传的原因:
							// 1. 使配置的noMoreSize 和 empty生效
							// 2. 判断是否有下一页的首要依据: 
							//    当传的值小于page.size时(说明不满页了),则一定会认为无更多数据;
							//    比传入的totalPage, totalSize, hasNext具有更高的判断优先级;
							// 3. 当传的值等于page.size时,才会取totalPage, totalSize, hasNext判断是否有下一页
							// 传totalPage, totalSize, hasNext目的是避免方法四描述的小问题
							console.log(that.cakeinfomation)
						},
						fail: () => {
							// 失败隐藏下拉加载状态
							mescroll.endErr()
						}
					})

				}, 1000)
				console.log("upCallback: ----stop :")
			},
			pupopOpen: function(cake) {
				//console.log('点了')
				//改变key创建information
				this.cakeInfomationOnShow = true
				//将点击物品的数据传入
				this.cakeinfomation = cake
				//显示
				this.$refs.popupRef.show()
				this.$refs.infomationBar.Initialization()
			},
			pupopClose: function() {
				this.cakeInfomationOnShow = false
				this.$refs.popupRef.close()
			}
		},
		onHide() {
			this.$refs.popupRef.close()
		},
		onLoad() {
			//服务器获取数据
			//今日折扣
			uni.request({
				url: this.httpDataUrl + "/cakeInfo/getCakeInfoByDay",
				success: (res) => {
					this.DiscountToday = res.data.data;
				}
			});
			//今日折扣倒计时
			//人气推荐
			uni.request({
				url: this.httpDataUrl + "/cakeInfo/getCakeInfoByPopulity",
				success: (res) => {
					this.Popular = res.data.data;
				}
			});
			//新品推荐推荐
			uni.request({
				url: this.httpDataUrl + '/cakeInfo/getAllCake?page=1&limit=8',
				success: (res) => {
					this.New = res.data.data;
				}
			});
		}
	}
</script>

<style>
	.swiper {
		height: 350upx;
	}

	swiper-item image {
		width: 100%;
		height: 350upx;
	}

	.my-card {
		background-color: #fff;
		width: 100%;
		border-radius: 20upx;
		background-color: #FFFFFF;
		box-shadow: 0upx 10upx 10upx #F3F3F3;
		box-sizing: border-box;
		padding: 0upx 30upx;
		padding-bottom: 30upx;
		margin-bottom: 20upx;
	}

	.menu {
		display: flex;
		padding: 20upx 0upx;
	}

	.menu>view {
		flex: 1;
		font-size: 24upx;
		text-align: center;
	}

	.menu-item image {
		width: 100upx;
		height: 100upx;
		display: block;
		margin: 10upx auto;
	}

	.item-card {
		background-color: #fff;
		width: 100%;
		border-radius: 20upx;
		background-color: #FFFFFF;
		box-sizing: border-box;
		padding: 0upx 30upx;
		margin-bottom: 20upx;
	}

	.item-title {
		font-weight: bold;
	}

	.cake-card-mini-box {
		width: 100%;
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: space-between;
	}
</style>
