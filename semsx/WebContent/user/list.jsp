<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자정보목록(테스트중)</title>

<link rel="stylesheet"
  href="../jquery/css/ui-lightness/jquery-ui-1.10.4.custom.min.css">
<script src="../jquery/js/jquery-1.10.2.js"></script>
<script src="../jquery/js/jquery-ui-1.10.4.custom.min.js"></script>
<jsp:include page="../header.jsp" />
<style>

body {
font-size: 62.5%;

display: block;
margin: 8px;

font-family: "Trebuchet MS", "Arial", "Helvetica", "Verdana", "sans-serif";

}


table {
border-collapse: separate;
border-spacing: 1px;
border-color: gray;
}


div#users-contain {
width: 350px;
margin: 20px 0;
}

.ui-widget {
font-family: Verdana,Arial,sans-serif/*{ffDefault}*/;
font-size: 1.1em/*{fsDefault}*/;
}

.ui-widget .ui-widget {
font-size: 1em;
}

div#users-contain table {
 margin: 1em 0;
 /* border-collapse: collapse; */
 width: 100%;
}

/* .ui-widget-header {
border: 1px solid #4297d7;
background: #5c9ccc url("images/ui-bg_gloss-wave_35_f6a828_500x100.png") 50% 50% repeat-x;
color: #fff;
font-weight: bold;
} */

$(function() {
    $( "input[type=submit], a, button" )
      .button()
      .click(function( event ) {
        event.preventDefault();
      });
  });

</style>
<script>
$(document).ready(function() {
	
	////////////////
	var name = $( "#name" ),
      email = $( "#email" ),
      password = $( "#password" ),
      allFields = $( [] ).add( name ).add( email ).add( password ),
      tips = $( ".validateTips" );
 
    function updateTips( t ) {
      tips
        .text( t )
        .addClass( "ui-state-highlight" );
      setTimeout(function() {
        tips.removeClass( "ui-state-highlight", 1500 );
      }, 500 );
    }
 
    function checkLength( o, n, min, max ) {
      if ( o.val().length > max || o.val().length < min ) {
        o.addClass( "ui-state-error" );
        updateTips( "Length of " + n + " must be between " +
          min + " and " + max + "." );
        return false;
      } else {
        return true;
      }
    }
 
    function checkRegexp( o, regexp, n ) {
      if ( !( regexp.test( o.val() ) ) ) {
        o.addClass( "ui-state-error" );
        updateTips( n );
        return false;
      } else {
        return true;
      }
    }
    
    /**
     * 입력값이 한글인지 체크
     */
    function is_hangul_char(ch) {
    	  c = ch.charCodeAt(0);
    	  if( 0x1100<=c && c<=0x11FF ) return true;
    	  if( 0x3130<=c && c<=0x318F ) return true;
    	  if( 0xAC00<=c && c<=0xD7A3 ) return true;
    	  return false;
    }
    
    
	////////////////
	
	$("#create-user").click(function () {
		  $("#create-form").dialog('open');
	});
	
	// new user dialog
	$( "#create-form" ).dialog({
	      autoOpen: false,
	      height: 350,
	      width: 350,
	      modal: true,
	      buttons: {
	        "등록": function() {
	          var bValid = true;
	          allFields.removeClass( "ui-state-error" );
	 
	          bValid = bValid && checkLength( name, "이름", 3, 16 );
	          bValid = bValid && checkLength( email, "이메일", 6, 80 );
	          bValid = bValid && checkLength( password, "비밀번호", 5, 16 );
	 
	          if (is_hangul_char($('#name').val())) { // 한글 입력 검사
	        	  if ( $('#name').val() == ' ' || $('#name').val() == "" ) {
	        		  bValid = false;
	        		  updateTips( "빈 문자는 입력할 수 없습니다." );
	        	  }
	          } else {
	            bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
	          }
	          
	          // From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
	          bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
	          bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
	          
	          bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
	 
	          
	          if ( bValid ) {
	        	  
	        	  // 사용자가 입력하지 않은 항목은 null 처리
	        		if ( $('#fax').val() == ' ' || $('#fax').val() == "" )
	              $('#fax').val('null');
	        		
	        		if ( $('#postNo').val() == ' ' || $('#postNo').val() == "" )
	              $('#postNo').val('null');
	        		
	        		if ( $('#addr').val() == ' ' || $('#addr').val() == "" )
	              $('#addr').val('null');
	        		
	        		if ( $('#photo').val() == ' ' || $('#photo').val() == "" )
	              $('#photo').val('null');
	        	  
	            $.ajax({
	                type: "POST", // POST형식으로 폼 전송
	                url: "insert.bit", // 목적지
	                timeout: 10000,
	                data: {
	                    name: $('#name').val(),
	                    email: $('#email').val(),
	                    password: $('#password').val(),
	                    tel: $('#tel').val(),
	                    fax: $('#fax').val(),
	                    postNo: $('#postNo').val(),
	                    addr: $('#addr').val(),
	                    photo: $('#photo').val()
	                  },
	                cache: false,
	                /* dataType: "json", */
	                success: function(result, status, xhr){
	                    if(xhr.readyState == 4 && xhr.status == 200) {
	                    	location.reload(true); // 여기서 refresh 해줘야 함.
	                    } else {
	                      alert('새 사용자 등록 실패!!!!');
	                      console.log(result);
	                    }
	                  },
	                error: function(xhr, textStatus, errorThrown) {
	                	 console.log('====errorThrown====>', errorThrown);
	                    alert("새 사용자 등록에 실패했습니다.");
	                }
	            });
	            
	            $( this ).dialog( "close" );
	          }
	        },
	        "취소": function() {
	          $( this ).dialog( "close" );
	        }
	      },
	      close: function() {
	        allFields.val( "" ).removeClass( "ui-state-error" );
	      }
	    });
});
</script>

</head>

<body>

<h1>사용자 정보 목록</h1>

<%-- 
<table border='1'>
<tr>
  <th>번호</th>
  <th>이름</th>
  <th>이메일</th>
  <th>전화번호</th>
</tr>
<% 
for(UsersVo user : list){%>
<tr>
  <td><%=user.getNo()%></td>
  <td><a href='detail.bit?no=<%=user.getNo()%>'><%=user.getName()%></a></td>
  <td><%=user.getEmail()%></td>
  <td><%=user.getTel()%></td>
</tr>
<%}%>
</table>
 --%>
<!-- <!-- ############## -->

<div id="users-contain" class="ui-widget">
<a href='user.html'>새사용자 등록</a><br>
<button id="create-user">새사용자</button><br>
<table id="users" class="ui-widget ui-widget-content">
    <thead>
      <tr class="ui-widget-header ">
        <th>번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${list}">
      <tr>
        <td>${user.no}</td>
			  <td><a href='detail.bit?no=${user.no}'>${user.name}</a></td>
			  <td>${user.email}</td>
			  <td>${user.tel}</td>
		  </tr>
		  </c:forEach>
    </tbody>
  </table>
</div>

<!-- 사용자 등록 다이얼로그 -->
<div id="create-form" title="새 사용자 등록">
  <p class="validateTips">필수 항목은 반드시 입력해 주세요.</p>
 
  <form>
  <fieldset>
    <input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all" placeholder="이메일(필수)"><br>
    <input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all" placeholder="비밀번호(필수)"><br>
    <input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all" placeholder="이름(필수)"><br>
    <input type="text" name="tel" id="tel" class="text ui-widget-content ui-corner-all" placeholder="전화번호(필수)"><br>
    <input type="text" name="fax" id="fax" class="text ui-widget-content ui-corner-all" placeholder="팩스"><br>
    <input type="text" name="postNo" id="postNo" class="text ui-widget-content ui-corner-all" placeholder="우편번호"><br>
    <input type="text" name="addr" id="addr" class="text ui-widget-content ui-corner-all" placeholder="주소"><br>
    <input type="text" name="photo" id="photo" class="text ui-widget-content ui-corner-all" placeholder="사진 URL" disabled><br>
  </fieldset>
  </form>
</div>
<!-- <!-- ############## -->

</body></html>
