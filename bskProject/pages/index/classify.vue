<template>
	<view>
		<uni-nav-bar id="header" fixed="true" paddingTop="0" borderTop="20px solid #fff">
			<view slot="left">
				<wuc-tab :tab-list="tabList1" :tabCur="TabCur1" @change="tabChange1" tab-class="text-center text-black bg-white"
				 select-class="text-pink text-xl"></wuc-tab>
			</view>
			<view slot="right">
				<image src="../../static/search.png" style="width: 40upx; height: 40upx; position: relative; top: 10upx;" mode="widthFix"></image>
			</view>
		</uni-nav-bar>
		<view style="height: 90upx;">
			<wuc-tab1 style="position: fixed; z-index: 100;" id="header1" :tab-list="tabList2" :tabCur="TabCur2" @change="tabChange2" tab-class="text-left text-black bg-white"
			 select-class="text-white text-xl"></wuc-tab1>
		</view>
		<!-- :style="{height: scrollviewHigh + 'px'}" style="height: 1100upx" -->
			<swiper :style="{height: scrollviewHigh + 'px'}" :current="TabCur1" class="swiper" duration="300" :circular="true" indicator-color="rgba(255,255,255,0)"
			 indicator-active-color="rgba(255,255,255,0)" @change="swiperChange1">
				<swiper-item class="swiper-item" v-for="(item,index) in tabList1" :key="index">
					<mescroll-uni bottom="0px" :down="downOption" @down="downCallback" :up="upOption[0]" @up="upCallback" style="height: auto;">
						<view class="cake-card-mini-box" style="padding: 0 30upx;box-sizing: border-box;">
							<cake-card-mini v-for="(cakeItem,cakeIndex) in New[TabCur1]" :key="cakeIndex" :cake="cakeItem" v-on:PupopOpen="pupopOpen"></cake-card-mini>
						</view>
					</mescroll-uni>
				</swiper-item>
			</swiper>
		<!-- 上拉 -->
		<popup-layer ref="popupRef" :direction="'top'">
			<cake-infomation-bar ref="infomationBar" :cakeInformation="cakeinfomation" @PupopClose="pupopClose" v-if="cakeInfomationOnShow"></cake-infomation-bar>
		</popup-layer>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	import WucTab from '@/components/wuc-tab/wuc-tab.vue'
	import WucTab1 from '@/components/wuc-tab1/wuc-tab1.vue'
	import cakeCardMini from "@/components/my-components/cake-card-mini.vue"
	import mescrollUni from "@/components/mescroll-uni/mescroll-uni.vue"
	import cakeInfomationBar from "@/components/my-components/cake-infomation.vue"
	import popupLayer from "@/components/popup-layer/popup-layer.vue"
	export default {
		components: {
			uniNavBar,
			WucTab,
			WucTab1,
			cakeCardMini,
			mescrollUni,
			cakeInfomationBar,
			popupLayer
		},
		data() {
			return {
				httpDataUrl: this.$httpUrl.dataUrl,
				httpStaticUrl: this.$httpUrl.staticUrl,
				scrollviewHigh: 0,
				cakeinfomation: {},
				//information组件key
				cakeInfomationOnShow: false,
				tabList1: [{
						name: '经典'
					},
					{
						name: '女神'
					},
					{
						name: '蜜糖'
					},
					{
						name: '伴手礼'
					}
				],
				TabCur1: 0,
				tabList2: [{
						name: '经典2'
					},
					{
						name: '女神2'
					},
					{
						name: '蜜糖2'
					},
					{
						name: '蜜糖2'
					},
					{
						name: '伴手礼2'
					}
				],
				TabCur2: 0,
				mescroll: [],
				tempFlag: 0,
				New: [],
				// 下拉刷新的常用配置
				downOption: {
					use: true, // 是否启用下拉刷新; 默认true
					auto: true, // 是否在初始化完毕之后自动执行下拉刷新的回调; 默认true
				},
				// 上拉加载的常用配置
				upOption: [{
					use: true, // 是否启用上拉加载; 默认true
					auto: false, // 是否在初始化完毕之后自动执行上拉加载的回调; 默认true
					page: {
						num: 0, // 当前页码,默认0,回调之前会加1,即callback(page)会从1开始
						size: 8 // 每页数据的数量,默认10
					},
					noMoreSize: 5, // 配置列表的总数量要大于等于5条才显示'-- END --'的提示
					empty: {
						tip: '暂无相关数据'
					}
				}],
				// 列表数据
				dataList: []
			}
		},
		onLoad() {
			uni.request({
				url: this.httpDataUrl + "/cakeClass/getAllCakeClass",
				success: (res) => {
					//console.log(res)
					this.tabList1 = res.data.data;
					this.upOption = []
					this.tabList1.forEach((item, i) => {
						this.requestCakeByClassMinId(i, 0)
						this.upOption.push({
							use: true, // 是否启用上拉加载; 默认true
							auto: false, // 是否在初始化完毕之后自动执行上拉加载的回调; 默认true
							page: {
								num: 0, // 当前页码,默认0,回调之前会加1,即callback(page)会从1开始
								size: 8 // 每页数据的数量,默认10
							},
							noMoreSize: 5, // 配置列表的总数量要大于等于5条才显示'-- END --'的提示
							empty: {
								tip: '暂无相关数据'
							}
						});
						//console.log(i)
					})
					this.requestClass2(this.tabList1[0].cakeclassId)
				}
			});
		},
		onShow() {
		},
		onReady() {
			let _this = this
			console.log("onReady----start")
			// 计算屏幕剩余高度  填补剩余高度
			uni.getSystemInfo({
				success(res) {
					//console.log(_this)
					_this.phoneHeight = res.windowHeight
					console.log(res.windowHeight)
					// 计算组件的高度
					let view = uni.createSelectorQuery().select("#header")
					let view1 = uni.createSelectorQuery().select("#header1")
					view.boundingClientRect(data => {
						console.log(data)
						_this.navHeight = data.height
						//console.log(_this)
						console.log("scrollviewHigh:  " + _this.scrollviewHigh)
					}).exec()
					view1.boundingClientRect(data => {
						console.log(data)
						_this.navHeight = _this.navHeight + data.height
						//console.log(_this)
						_this.scrollviewHigh = _this.phoneHeight - _this.navHeight
						let viewHight = _this.phoneHeight - _this.navHeight
						console.log("scrollviewHigh:  " + viewHight)
						// // iphone 4
						// if(0<viewHight&&340>=viewHight){
						// 	_this.scrollviewHigh = 780/2
						// }
						// // iphone 5
						// if(340<viewHight&&425>=viewHight){
						// 	_this.scrollviewHigh = 980/2
						// }
						// // iphone 6
						// if(425<viewHight&&510>=viewHight){
						// 	_this.scrollviewHigh = 1010/2
						// }
						// // iphone Plus
						// if(510<viewHight&&570>=viewHight){
						// 	_this.scrollviewHigh = 1020/2
						// }
						// // iphone X
						// if(570<viewHight&&655>=viewHight){
						// 	_this.scrollviewHigh = 1300/2
						// }
						// if(viewHight>730){
						// 	_this.scrollviewHigh = 1300/2
						// }
						
					}).exec()
				}
			})
			console.log("onReady----stop")
		},
		methods: {
			// 点击切换页面
			tabChange1(index) {
				this.TabCur1 = index;
				this.TabCur2 = 0;
				this.requestClass2(this.tabList1[index].cakeclassId)
				//console.log(this.tabList2)
				console.log("点击")
				this.downCallback(this.mescroll[this.TabCur1])
			},
			// 滑动切换页面
			swiperChange1(e) {
				let {
					current
				} = e.target;
				this.TabCur1 = current;
				console.log("滑动")
				this.requestClass2(this.tabList1[this.TabCur1].cakeclassId)
				this.downCallback(this.mescroll[this.TabCur1])
				//this.requestClass2(this.tabList1[current].cakeclassId)
				//this.TabCur2 = 0;
			},
			tabChange2(index) {
				this.TabCur2 = index;
				//this.requestCakeByClassMinId(this.TabCur1, this.tabList2[this.TabCur2].cakeclassminId)
				this.New[this.TabCur1] = []
				this.downCallback(this.mescroll[this.TabCur1])
			},
			swiperChange2(e) {
				let {
					current
				} = e.target;
				this.TabCur2 = current;
			},
			requestClass2(cakeclassminClassid) {
				this.tabList2 = []
				uni.request({
					url: this.httpDataUrl + "/cakeClassMin/getAllCakeClassMinByClassId",
					data: {
						cakeclassminClassid: cakeclassminClassid
					},
					success: (res) => {
						//console.log(res)
						this.tabList2 = res.data.data;
						this.tabList2.unshift({
							cakeclassminId: 0,
							cakeclassminClassid: cakeclassminClassid,
							cakeclassminName: "全部",
							cakeclassminInfo: ""
						})
						// this.requestCakeByClassMinId(this.TabCur1, this.tabList2[this.TabCur2].cakeclassminId)
						//console.log(this.tabList2)
					}
				});
			},
			requestCakeByClassMinId(tabCur1, id) {
				this.New[tabCur1] = []
				//console.log("id:  "+id)
				if (id == 0) {
					uni.request({
						url: this.httpDataUrl + "/cakeInfo/getAllCakeInfoByClassId",
						data: {
							cakeClassid: this.tabList1[tabCur1].cakeclassId,
							page: 1,
							limit: 8
						},
						success: (res) => {
							//console.log(res)
							this.New[tabCur1] = res.data.data
							// 强制刷新-------------------cnmd
							this.$forceUpdate()
							//console.log(this.New)
						}
					});
				} else {
					uni.request({
						url: this.httpDataUrl + "/cakeInfo/getAllCakeInfoByClassMinId",
						data: {
							cakeClassminid: id,
							page: 1,
							limit: 8
						},
						success: (res) => {
							//console.log(res)
							this.New[tabCur1] = res.data.data
							// 强制刷新-------------------cnmd
							this.$forceUpdate()
							//console.log(this.New)
						}
					});
				}

			},
			/*下拉刷新的回调, 有三种处理方式: */
			downCallback(mescroll) {
				this.tempFlag++
				if (this.tempFlag <= this.tabList1.length) {
					this.mescroll.push(mescroll)
					console.log(this.tempFlag)
				}

				let that = this
				console.log(this.tabList1[this.TabCur1])
				// if(this.tabList2[this.TabCur2].cakeclassminId==0){
				// 第1种: 请求具体接口
				// uni.request({
				// 	url: this.httpDataUrl + "/cakeInfo/getAllCakeInfoByClassId",
				// 	data:{
				// 		cakeClassid:this.tabList1[this.TabCur1].cakeclassId,
				// 		page: 1,
				// 		limit: 4
				// 	},
				// 	success: (res) => {
				// 		//console.log(res)
				// 		this.New[this.TabCur1]=res.data.data
				// 		console.log(this.New)
				// 		// 成功隐藏下拉加载状态
				// 		setTimeout(function(){
				// 			mescroll.endSuccess()
				// 		}, 2000)

				// 	},
				// 	fail: (res) => {
				// 		// 失败隐藏下拉加载状态
				// 		mescroll.endErr()
				// 	},
				// 	complete() {
				// 		setTimeout(function() {
				// 			mescroll.endSuccess()
				// 		}, 2000)
				// 		// 强制刷新-------------------cnmd
				// 		that.$forceUpdate()
				// 	}
				// })
				// 第2种: 下拉刷新和上拉加载调同样的接口, 那以上请求可删, 直接用mescroll.resetUpScroll()代替
				mescroll.resetUpScroll(); // 重置列表为第一页 (自动执行 page.num=1, 再触发upCallback方法 )
				// 第3种: 下拉刷新什么也不处理, 可直接调用或者延时一会调用 mescroll.endSuccess() 结束即可
				//mescroll.endSuccess()
				// } else {
				// 第1种: 请求具体接口
				// uni.request({
				// 	url: this.httpDataUrl + "/cakeInfo/getAllCakeInfoByClassMinId",
				// 	data:{
				// 		cakeClassminid:this.tabList2[this.TabCur2].cakeclassminId,
				// 		page: 1,
				// 		limit: 4
				// 	},
				// 	success: (res) => {
				// 		//console.log(res)
				// 		this.New[this.TabCur1]=res.data.data
				// 		//console.log(this.New)
				// 		// 成功隐藏下拉加载状态
				// 		setTimeout(function(){
				// 			mescroll.endSuccess()
				// 		}, 2000)

				// 	},
				// 	fail: (res) => {
				// 		// 失败隐藏下拉加载状态
				// 		mescroll.endErr()
				// 	},
				// 	complete() {
				// 		setTimeout(function() {
				// 			mescroll.endSuccess()
				// 		}, 2000)
				// 		// 强制刷新-------------------cnmd
				// 		that.$forceUpdate()
				// 	}
				// })
				// 第2种: 下拉刷新和上拉加载调同样的接口, 那以上请求可删, 直接用mescroll.resetUpScroll()代替
				// mescroll.resetUpScroll(); // 重置列表为第一页 (自动执行 page.num=1, 再触发upCallback方法 )
				// 第3种: 下拉刷新什么也不处理, 可直接调用或者延时一会调用 mescroll.endSuccess() 结束即可
				//mescroll.endSuccess()
				// }

			},
			/*上拉加载的回调*/
			upCallback(mescroll) {
				console.log("upCallback: ----start :")
				console.log(mescroll)
				// 此时mescroll会携带page的参数:
				let pageNum = mescroll.num; // 页码, 默认从1开始
				let pageSize = mescroll.size; // 页长, 默认每页10条
				let that = this
				console.log(pageNum + " " + pageSize)
				setTimeout(function() {
					if (that.tabList2[that.TabCur2].cakeclassminId == 0) {
						uni.request({
							url: that.httpDataUrl + "/cakeInfo/getAllCakeInfoByClassId",
							data: {
								cakeClassid: that.tabList1[that.TabCur1].cakeclassId,
								page: pageNum,
								limit: pageSize
							},
							success: (data) => {
								// 接口返回的当前页数据列表 (数组)
								let curPageData = data.data.data;
								// 接口返回的总数据量(比如列表有26个数据,每页10条,共3页; 则totalSize值为26)
								let totalSize = data.data.count;

								//设置列表数据
								if (mescroll.num == 1) that.New[that.TabCur1] = []; //如果是第一页需手动置空列表
								that.New[that.TabCur1] = that.New[that.TabCur1].concat(curPageData); //追加新数据
								console.log(that.New[that.TabCur1])
								// 成功隐藏下拉加载状态
								//方法二(推荐): 后台接口有返回列表的总数据量 totalSize
								mescroll.endBySize(curPageData.length, totalSize);
							},
							fail: () => {
								// 失败隐藏下拉加载状态
								mescroll.endErr()
							},
							complete() {
								// 强制刷新-------------------cnmd
								that.$forceUpdate()
							}
						})
					} else {
						uni.request({
							url: that.httpDataUrl + "/cakeInfo/getAllCakeInfoByClassMinId",
							data: {
								cakeClassminid: that.tabList2[that.TabCur2].cakeclassminId,
								page: pageNum,
								limit: pageSize
							},
							success: (data) => {
								// 接口返回的当前页数据列表 (数组)
								let curPageData = data.data.data;
								// 接口返回的总数据量(比如列表有26个数据,每页10条,共3页; 则totalSize值为26)
								let totalSize = data.data.count;

								//设置列表数据
								if (mescroll.num == 1) that.New[that.TabCur1] = []; //如果是第一页需手动置空列表
								that.New[that.TabCur1] = that.New[that.TabCur1].concat(curPageData); //追加新数据
								console.log(that.New[that.TabCur1])
								// 成功隐藏下拉加载状态
								//方法二(推荐): 后台接口有返回列表的总数据量 totalSize
								mescroll.endBySize(curPageData.length, totalSize);
							},
							fail: () => {
								// 失败隐藏下拉加载状态
								mescroll.endErr()
							},
							complete() {
								// 强制刷新-------------------cnmd
								that.$forceUpdate()
							}
						})
					}
				}, 1000);
				

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
		}
	}
</script>

<style>
	.cake-card-mini-box {
		width: 100%;
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: space-between;
	}
	/* .swiper{
		width: 100%;
		height: 100%;
		position: absolute;
		padding-top: 200upx;
	} */
</style>
