<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  
  <head>
    <meta charset="UTF-8">
    <title>BBS论坛系统——用户修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/xadmin.css">
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
        <form class="layui-form" id="apk_add_form" enctype="multipart/form-data">
         <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>用户名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_username" name="userid" value="${users.userid }" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input" readonly="readonly">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" value="${users.usermail }" lay-verify="email"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>作为修改密码的条件
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>性别
              </label>
              <div class="layui-input-inline">
                  <c:if test="${users.usersex eq '男'  }">
                  	<input type="radio" id="L_username" name="usersex" value="男" lay-verify="nikename"
	                  autocomplete="off" class="layui-input" checked="checked">男
	                <input type="radio" id="L_username" name="usersex" value="女" required="" lay-verify="nikename"
	                  autocomplete="off" class="layui-input">女
                  </c:if>
                  <c:if test="${users.usersex eq '女' }">
                  	<input type="radio" id="L_username" name="usersex" value="男" lay-verify="nikename"
	                  autocomplete="off" class="layui-input" checked="checked">男
	                <input type="radio" id="L_username" name="usersex" value="女" required="" lay-verify="nikename"
	                  autocomplete="off" class="layui-input" checked="checked">女
                  </c:if>
              </div>
          </div>
           <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>添加头像
              </label>
              <div class="layui-input-inline">
                  <button type="button" class="layui-btn" id="upload">选择头像</button>
                  <p id="ImgSrc"></p>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  修改
              </button>
          </div>
      </form>
    </div>
    <script>
      layui.use(['form','layer'], function(){
          $ = layui.jquery;
        var form = layui.form
        ,layer = layui.layer;
      
        //自定义验证规则
        form.verify({
          userid: function(value){
            if(value.length< 4){
              return '昵称至少得4个字符啊';
            }
          }
          ,pass: [/(.+){6,12}$/, '密码必须6到12位']
          ,repass: function(value){
              if($('#L_pass').val()!=$('#L_repass').val()){
                  return '两次密码不一致';
              }
          }
        });
        //序列化表单
  	    $.fn.extend({
  	        serializeObject : function() {
  	            var o = {};
  	            var a = this.serializeArray();
  	            $.each(a, function() {
  	                if(this.name != "file"){
  	                	//排除文件上传
  	                    if (o[this.name]) {
  	                        if (!o[this.name].push) {
  	                            o[this.name] = [ o[this.name] ];
  	                        }
  	                        o[this.name].push(this.value || '');
  	                    } else {
  	                        o[this.name] = this.value || '';
  	                    }
  	                }
  	            });
  	            return o;
  	        }
  	    });
  	
  		layui.use('upload', function(){
  			  var $ = layui.jquery
  			  ,upload = layui.upload;
  			  
  			  //普通图片上传
  			  var uploadInst = upload.render({
  			    elem: '#upload'
  			    ,url: '${pageContext.request.contextPath }/UserUpdate'
  			    ,before: function(obj){
  			    	this.data= $('#apk_add_form').serializeObject();
  			      //预读本地文件示例，不支持ie8
  			      obj.preview(function(index, file, result){
  			        $('#ImgSrc').val(result); //图片链接（base64）
  			      });
  			    }
  			    ,done: function(res){
  			      //如果上传失败
  			      if(res.code > 0){
  			    	//关闭当前frame
                    //x_admin_close();
                    // 可以对父窗口进行刷新 
                    x_admin_father_reload();
  			        return layer.msg('上传失败');
  			      }else{
  	  			      //上传成功
  			    	  //关闭当前frame
                      x_admin_close();
                      // 可以对父窗口进行刷新 
                      x_admin_father_reload();}
  			    }
  			    ,error: function(){
  			      //演示失败状态，并实现重传
  			      var demoText = $('#demoText');
  			      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
  			      demoText.find('.demo-reload').on('click', function(){
  			        uploadInst.upload();
  			      });
  			    }
  			  });
  		});
      });
  </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>