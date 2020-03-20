<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  <head>
    <meta charset="UTF-8">
    <title>BBS论坛系统——回帖管理</title>
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
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="${pageContext.request.contextPath }/InvitationServlet?op=like" method="post">
          <input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end">
          <input type="text" name="invitationid"  placeholder="请输入主贴Id" autocomplete="off" class="layui-input">
          <button class="layui-btn" type="submit" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('板块添加','${pageContext.request.contextPath }/server/invitation-add.jsp')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：22条</span>
      </xblock>
      <table class="layui-table x-admin">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>回帖编号</th>
            <th>回帖信息</th>
            <th>主贴Id</th>
            <th>回帖账户</th>
            <th>回帖时间</th>
            <th >操作</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach items="${invitation_ans}" var="ins"> 
		       <tr>
		            <td>
		              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${ins.ansid }'><i class="layui-icon">&#xe605;</i></div>
		            </td>
		            <td>${ins.ansid }</td>
		            <td>.......<%-- ${ins.ansmessage } --%></td>
		            <td>${ins.invitationid }</td>
		            <td>${ins.userid }</td>
		            <td>${ins.ansdate }</td>
		            <td class="td-manage">
		              <a title="修改"  onclick="x_admin_show('编辑','${pageContext.request.contextPath}/InvitationServlet?op=findid&invitationId=${in.invitationid }')" href="javascript:;">
		                <i class="layui-icon">&#xe63c;</i>
		              </a>
		              <a title="删除" onclick="member_del(this,'${in.invitationid }')" href="javascript:;">
		                <i class="layui-icon">&#xe640;</i>
		              </a>
		            </td>
		          </tr>
           </c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').jsp('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').jsp('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').jsp('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').jsp('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*单行删除  */
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
        	  //发异步删除数据
        	  $.ajax({
            	  url:"${pageContext.request.contextPath }/InvitationServlet?op=del",
	              type:"post",
	              data:"id="+id,
                  dataType:"text",// servlet中返回的是普通文本
          	      success:function(text){
          		    if(text.trim()=="true"){
          		    	layer.msg('已删除!',{icon:1,time:1000});
          		    	//刷新当前页面
          		    	x_admin_father_reload();
	          		}else{
	          			 layer.msg('删除失败!',{icon:1,time:1000});
	          			 //刷新当前页面
	          			 x_admin_father_reload();
	          		}
          	      }
             });
          });
      }
      //多行删除
      function delAll (argument) {
        var data = tableCheck.getData();  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            //layer.msg('删除成功', {icon: 1});
            //$(".layui-form-checked").not('.header').parents('tr').remove();
            $.ajax({
          	  url:"${pageContext.request.contextPath }/InvitationServlet?op=delall",
	              type:"post",
	              data:"id="+data,
                dataType:"text",// servlet中返回的是普通文本
        	      success:function(text){
        		    if(text.trim()=="true"){
        		    	layer.msg('已删除!',{icon:1,time:1000});
        		    	//刷新当前页面
        		    	x_admin_father_reload();
	          		}else{
	          			 layer.msg('删除失败!',{icon:1,time:1000});
	          			 //刷新当前页面
	          			 x_admin_father_reload();
	          		}
        	      }
           });
        });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>
</html>