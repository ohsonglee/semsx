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
   
            // bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$+/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
            // From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
            bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
            bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
   
            if ( bValid ) {
              
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
                        // refresh 필요
                        location.reload(true);
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
