<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i,500,500i,600&display=swap" rel="stylesheet">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
  <!-- Fontawesome CSS-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/all.css" />
  <!-- slick css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/slick.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/slick-theme.css">
  <!-- Custom CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/preloader.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/responsive.css" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/wangEditor.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/static/lib/layui/css/layui.css">
  <title>回帖</title>
</head>
<body>
  <main class="kavya-single">
    <!-- single layout blog content -->
    <section class="single-layout">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
            <div class="blog-content-wrap">      
              <div class="blog-author-info">
                <div class="author-img">
                  <img src="${pageContext.request.contextPath}/static/images/writer.jpg" alt="">
                </div>
                <div class="author-desc">
                  <small>作者</small>
                  <h5>${intion.userid }</h5>
                  <p>${intion.invitationmessage }</p>
                </div>
              </div>
              <!--点击展示按钮  -->
              <div class="comment-section">
                <div class="all-response">
                  <a class="btn view-all-btn" data-toggle="collapse" href="#collapseExample" role="button"
                    aria-expanded="false" aria-controls="collapseExample">
                             评论展示
                  </a>
                </div>
                <div class="collapse" id="collapseExample">       
                <!--展示开始  -->     
                <c:forEach items="${in_ans }" var="ans">
                  <div class="card comment-card">
                    <div class="card-body">
                      <div class="author-date">
                        <div class="author">
                          <img src="${pageContext.request.contextPath}/static/images/person2.jpg" alt="" class="rounded-circle" />
                        </div>
                        <div class="inner-author-date">
                          <div class="author">
                            <span class="">${ans.userid }</span>
                          </div>
                          <div class="date"><span>${ans.ansdate }</span></div>
                        </div>
                      </div>
                      <div class="comment-text mt-2">
                        <div>${ans.ansmessage }</div>
                      </div>
                    </div>
                  </div>
                 </c:forEach>       
                 <!--展示结束  -->
                </div>
                <form class="layui-form">
                  <h5 style="text-align: center;">发表评论</h5>
                  <div  class="layui-form-item">
                    <div class="layui-input-block">
                       <div id="editor">
                       </div>
                        <textarea style="display: none;" name="contents" id="message"></textarea>     
                    </div>
                  </div>
                  <button class="layui-btn site-demo-layedit" lay-filter="add" lay-submit="" data-type="content">增加</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Single Layout Blog content end -->   
  </main>
  <!--layUI  -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/cookie.js"></script>
  <!-- Javascript -->
  <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/slick.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.sticky.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/ResizeSensor.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/theia-sticky-sidebar.min.js"></script>
  <script src="https://platform-api.sharethis.com/js/sharethis.js#property=5e14739168a9ad001281e73c&product=inline-share-buttons"
    async="async"></script>
      <script type="text/javascript">
         var U =window.wangEditor;//获得一个富文本编辑器对象
         var editor=new  U("#editor");
         //创建出编辑器
         editor.customConfig.onchange = function (html) {
             // 监控变化，同步更新到 textarea
             document.getElementById("message").value=html;
         }
         editor.create();
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
     		 url:"${pageContext.request.contextPath }/Invitation_ans?op=add&id=${intion.invitationid }",
     		 type:"post",
     		 data:data.field,
     		 dataType:"text",
     		 success:function(res){
     		 if(res.trim()=="true"){
     				 layer.alert("增加成功", {icon: 6},function () {
     		                // 可以对父窗口进行刷新 
     		                x_admin_father_reload();
     		            });
     			 }else{
     				 layer.alert("增加失败", {icon: 2},function () {
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
</body>
</html>