<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		},
		add: function(aaa,bbb){
			return aaa+bbb
		}
	}
</script>

<style>
	/*每个页面公共css */
	text,view{
		color: #333333;
	}
	page {
		background-color: #FFFFFF;
		/* border-top: 40rpx solid #FFFFFF; */
	}
</style>
