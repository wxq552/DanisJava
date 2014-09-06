<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">  
<html  xmlns="http://www.w3.org/1999/xhtml">  
<head>  
<title>客户留言</title>  
<meta http-equiv="Content-Type" content="text/html" charset="utf-8"    />  
<link rel="stylesheet" type="text/css" href="./css/home.css" />
<link rel="stylesheet" type="text/css" href="./css/p_show.css" />
<link rel="stylesheet" type="text/css" href="./css/company.css" />
<script type="text/javascript" src="./js/P_show.js"></script>
</head>  
<script language="javascript" type="text/javascript">
<!--
//获得当前时间,刻度为一千分一秒
var initializationTime=(new Date()).getTime();
function showLeftTime()
{
var now=new Date();
var year=now.getFullYear();
var month=now.getMonth()+1;
var day=now.getDate();
var hours=now.getHours();
var minutes=now.getMinutes();
var seconds=now.getSeconds();
document.getElementById('show').textContent=""+year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds+"";//一秒刷新一次显示时间
var timeID=setTimeout(showLeftTime,1000);
}
//-->
</script>
</head>  
<body onload="showLeftTime()">  
    <div class="all">  
        <div id="topbar">
            <div class="t_content">
                <div class="logo"><img alt="logo" src="./images/LOGO.png" width="245px" height="100px"></div>
                <div class="t_input">
                    <input class="s-text" type="text" name="" autocomplete="off" value="请输入关键字" x-webkit-speech="" id="">
                    <div class="s-submit"></div>    
                    <div class="t_time">欢迎您！现在是<label id="show">显示时间的位置</label></div>
                </div>
            </div>

            <div class="nav">
                <ul>
                    <li><a href="redirect.jsp" alt="home">首页</a></li>
                    <li><a alt="introdution">公司简介</a>
                        <ul class="order">
                            <li><a href="company_introdute.jsp">公司简介</a></li>
                            <li><a href="company_culture.jsp">企业文化</a></li>
                        </ul>
                    </li>
                    <li><a  alt="glory">公司荣誉</a>
                        <ul class="order">
                             <li><a href="getglory.html">公司荣誉</a></li>
                            <li><a href="getdevice.html">设备展示</a></li>
                        </ul>
                    </li>
                    <li><a alt="product">产品展示</a>
                        <ul class="order">
                             <c:forEach items="${sessionScope.types}" var="type">
                           <li><a href="product_type.html?pro.type=${type}">${type}</a></li>
                              </c:forEach>
                           <li><a href="">更多</a></li>
                        </ul>
                    </li>
                    <li><a alt="new">新闻动态</a>
                        <ul class="order">
                            <li><a href="new.html">新闻动态</a></li>
                            <li><a href="packing.html">包装常识</a></li>
                        </ul>
                    </li>
                    <li><a alt="jobs">人才招聘</a>
                        <ul class="order">
                            <li><a href="jobs.html">人才招聘</a></li>
                        </ul>
                    </li>
                    <li><a alt="about">联系我们</a>
                        <ul class="order">
                             <li><a href="contact.jsp">联系方式</a></li>
                            <li><a href="clientele.jsp">客户留言</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>  
        <div class="main">
            <div class="p_show">
                <div id="slideBox">
                    <ul id="show_pic" style="left:0px">
                       <c:forEach items="${sessionScope.surfaces}" var="sur">
                         <li><a href="#" target="_blank"><img  alt="图片"  title="" height="300" width="1005" src="${ctx}/upload${sur.pic_address}" /></a></li>
                         </c:forEach>
                    </ul>
                    <ul id="textBall">
                        <li><a href="javascript:void(0)"></a></li>
                        <li><a href="javascript:void(0)"></a></li>
                        <li><a href="javascript:void(0)"></a></li>
                    </ul>
                </div><!--slideBox end-->
                <div>
                    <ul id="iconBall">
                        <li class="active"></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div> 
            </div><!--p_show end-->
            <div class="main_content">
                <div class="left_content">
                    <ul>
                         <c:forEach items="${sessionScope.types}" var="type">
                           <li><a href="product_type.html?pro.type=${type}">${type}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="right_content">
                    <div class="right_position">您当前的位置：<a href="redirect.jsp" alt="之前的位置">首页</a> --  <span>客户留言</span></div>
                    <div class="right_clientele">
                        <form id="feedbacksmallform" method="post" action="addmessage.html" name="gform">
                            <table>
                                <tr>
                                    <td class="td">反馈主题：</td>
                                    <td>
                                        <textarea name="mes.topic"  rows="1" class="textarea"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td">反馈内容：</td>
                                    <td>
                                        <textarea name="mes.content"  rows="10" class="textarea"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td">客户名称：</td>
                                    <td>
                                        <textarea name="mes.custom"  rows="1" class="textarea"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td">联系人：</td>
                                    <td>
                                        <textarea name="mes.contactor"  rows="1" class="textarea"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td">联系电话：</td>
                                    <td>
                                        <textarea name="mes.contact_phone"  rows="1" class="textarea"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td">QQ/MSN：</td>
                                    <td>
                                        <textarea name="mes.qq"  rows="1" class="textarea"></textarea>
                                    </td>    
                                </tr>  
                            </table>
                            <div class="right_clientele_special">
                                <input type="submit" name="Submit" value="提交" />
                                <input type="reset" name="reset" value="重置" />
                            </div> 
                        </form>
                    </div>
                </div>
                <div class="clear"></div>

            </div>
            
            <div class="footer">
                <div class="footer_content">
                    地 址：杭州市莫干山路2168号
                    电 话：0571-98765432
                    联系人：杨军(经理)
                    手 机：15887654321
                    网址：www.aaaa.com
                    邮 箱：bos@mail.com
                </div>
                <div class="span"></div>
            </div> 
        </div> 
    </div>  
<script type="text/javascript">
var glide =new function(){
    function $id(id){return document.getElementById(id);};
    this.layerGlide=function(auto,oEventCont,oTxtCont,oSlider,sSingleSize,second,fSpeed,point){
        var oSubLi = $id(oEventCont).getElementsByTagName('li');
        var oTxtLi = $id(oTxtCont).getElementsByTagName('li');
        var interval,timeout,oslideRange;
        var time=1; 
        var speed = fSpeed 
        var sum = oSubLi.length;
        var a=0;
        var delay=second * 2000; 
        var setValLeft=function(s){
            return function(){
                oslideRange = Math.abs(parseInt($id(oSlider).style[point]));    
                $id(oSlider).style[point] =-Math.floor(oslideRange+(parseInt(s*sSingleSize) - oslideRange)*speed) +'px';        
                if(oslideRange==[(sSingleSize * s)]){
                    clearInterval(interval);
                    a=s;
                }
            }
        };
        var setValRight=function(s){
            return function(){      
                oslideRange = Math.abs(parseInt($id(oSlider).style[point]));                            
                $id(oSlider).style[point] =-Math.ceil(oslideRange+(parseInt(s*sSingleSize) - oslideRange)*speed) +'px';
                if(oslideRange==[(sSingleSize * s)]){
                    clearInterval(interval);
                    a=s;
                }
            }
        }
        
        function autoGlide(){
            for(var c=0;c<sum;c++){oSubLi[c].className='';oTxtLi[c].className='';};
            clearTimeout(interval);
            if(a==(parseInt(sum)-1)){
                for(var c=0;c<sum;c++){oSubLi[c].className='';oTxtLi[c].className='';};
                a=0;
                oSubLi[a].className="active";
                oTxtLi[a].className = "active";
                interval = setInterval(setValLeft(a),time);
                timeout = setTimeout(autoGlide,delay);
            }else{
                a++;
                oSubLi[a].className="active";
                oTxtLi[a].className = "active";
                interval = setInterval(setValRight(a),time);    
                timeout = setTimeout(autoGlide,delay);
            }
        }
    
        if(auto){timeout = setTimeout(autoGlide,delay);};
        for(var i=0;i<sum;i++){ 
            oSubLi[i].onmouseover = (function(i){
                return function(){
                    for(var c=0;c<sum;c++){oSubLi[c].className='';oTxtLi[c].className='';};
                    clearTimeout(timeout);
                    clearInterval(interval);
                    oSubLi[i].className = "active";
                    oTxtLi[i].className = "active";
                    if(Math.abs(parseInt($id(oSlider).style[point]))>[(sSingleSize * i)]){
                        interval = setInterval(setValLeft(i),time);
                        this.onmouseout=function(){if(auto){timeout = setTimeout(autoGlide,delay);};};
                    }else if(Math.abs(parseInt($id(oSlider).style[point]))<[(sSingleSize * i)]){
                            interval = setInterval(setValRight(i),time);
                        this.onmouseout=function(){if(auto){timeout = setTimeout(autoGlide,delay);};};
                    }
                }
            })(i)           
        }
    }
}

//调用语句
glide.layerGlide(
    true,         //设置是否自动滚动
    'iconBall',   //对应索引按钮
    'textBall',   //标题内容文本
    'show_pic',   //焦点图片容器
    1005,          //设置滚动图片位移像素
    2,            //设置滚动时间2秒 
    0.1,          //设置过渡滚动速度
    'left'        //设置滚动方向“向左”
);
</script>
</body>  
</html>  