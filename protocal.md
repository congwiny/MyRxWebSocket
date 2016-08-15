# 聊天(推送)服务器协议


### 消息为 json 格式，
#### 发送消息格式为
	{		
		client_id: 客户端ID
		user_id: 用户ID
		room_id: 房间ID
		live_id: 直播ID
		type:	消息类型
		sys_type: 系统消息类型
		content: 消息内容
		action:  message/notification
		user: {
	      "avatar_url":"http://s3-us-west-2.amazonaws.com/solomedia/image/100117/avatar/61d11f8c96395416a299010363bf15f8.0",
	      "level":15,
	      "nickname":"Evan😍",
	      "user_id":100117
	   }
	}
	
SYSTEM = 1    	# 系统消息  
PUBLIC = 2		# 广播消息， 房间内群聊   
LIKE = 3			# 标记喜欢  
GIFT = 4			# 赠送礼物  
SHARED = 5		#   
STICKER = 6		
BIND_USER = 7		# 绑定用户  
PING = 8			# 心跳检测

在 type 为 1 时, sys_type 取值  
NOTICE = 11		
FOLLOW = 12		# 关注  
BANNED = 13		# 禁用户   
JOIN = 14			# 进入房间   
HOST_LEAVE = 15	# 主播离开   
HOST_BACK = 16	# 主播回到房间  

UNFOLLOW = 17		# 取消关注  
LEAVE = 18		# 用户离开房间  
START_LIVE = 19	# 开始直播  
END_LIVE = 20		# 结束直播

