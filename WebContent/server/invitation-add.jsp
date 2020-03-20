<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  <head>
    <meta charset="UTF-8">
    <title>BBS论坛系统——帖子管理-增加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/lib/layui/css/layui.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>帖子信息
              </label>
              <div class="layui-input-block">
                  <!--layUI富文本编辑器  -->
                  	<textarea class="layui-textarea" id="LAY_demo1" style="display: none">  
                                             请输入评论信息
                    </textarea>
                   <!--需要传递到后台的一个input元素  -->
                   <input type="hidden" id="input" name="message" value="" required="" lay-verify="message"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>所属模块
              </label>
              <div class="layui-input-inline">
                   <select name="plateId">
                       <c:forEach items="${plate }" var="pl">
			             <option value="${pl.plateid }">${pl.platetitle }</option>
			           </c:forEach>
                    </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>帖子分类
              </label>
             <div class="layui-input-inline">
                 <select name="categoryId">
                    <c:forEach items="${category }" var="ca">
			          <option value="${ca.categoryid }">${ca.category }</option>
			         </c:forEach>
                 </select>
              </div>
          </div>         
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button class="layui-btn site-demo-layedit" lay-filter="add" lay-submit="" data-type="content">
                          增加
              </button>
          </div>
      </form>
    </div>
    <!--富文本编辑器  -->
    <script>
		layui.use('layedit', function() {
			var layedit = layui.layedit, $ = layui.jquery;
			//构建一个默认的编辑器
			var index = layedit.build('LAY_demo1', {
				tool: [
					  'strong' //加粗
					  ,'italic' //斜体
					  ,'underline' //下划线
					  ,'del' //删除线
					  ,'|' //分割线1
					  ,'left' //左对齐
					  ,'center' //居中对齐
					  ,'right' //右对齐
					  ,'|' //分割线2
					  ,'link' //超链接
					  ,'unlink' //清除链接
					  ,'face' //表情
					  ,'image' //插入图片
					  ,'help' //帮助
					],
				height : 100
			});
			//编辑器外部操作
			var active = {
				content : function() {
					//将富文本框的内容添加到表单
					alert(layedit.getContent(index)); //获取编辑器内容
					document.getElementById("input").value=layedit
							.getContent(index); //给hidden赋值
				}
			};
			//帮助按钮
			$('.site-demo-layedit').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
		});
	</script>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });
         //监听提交
         form.on('submit(add)', function(data){
          $.ajax({
     		 url:"${pageContext.request.contextPath}/InvitationServlet?op=add",
     		 type:"post",
     		 data:data.field,
     		 dataType:"text",
     		 success:function(res){
     		 if(res.trim()=="true"){
     				 layer.alert("增加成功", {icon: 6},function () {
     		                // 获得frame索引
     		                var index = parent.layer.getFrameIndex(window.name);
     		                //关闭当前frame
     		                parent.layer.close(index);
     		                // 可以对父窗口进行刷新 
     		                x_admin_father_reload();
     		            });
     			 }else{
     				 layer.alert("增加失败", {icon: 2},function () {
  		                // 获得frame索引
  		                var index = parent.layer.getFrameIndex(window.name);
  		                //关闭当前frame
  		                parent.layer.close(index);
  		                // 可以对父窗口进行刷新 
  		                x_admin_father_reload();
  		            });
     			 }
     		 }
     	  });         
         return false;
       });   
     });
    </script>
    <script>
    var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();
    </script>
  </body>
</html>