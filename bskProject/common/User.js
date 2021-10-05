export default {
	//登录用户信息
	user:{},
	session:"",
	addUser(User) {
		this.user = User
	},
	addSession(Session){
		this.session = Session
	}
}