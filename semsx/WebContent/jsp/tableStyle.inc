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