<!DOCTYPE html>
<html lang="en">
  <head>
     <meta charset="utf-8">
     <title>Flicky from Hashedin</title>
     <meta name="viewport" content="width=device-width, initial-scale=1.0" />
     <meta name="description" content="Flicky Application"/>
     <meta name="keyword" content = "HTML,HTML5,CSS,Javascript" />
     <meta name="author" content="Somit Srivastava" />
     
    <!-- Le styles -->
     <link rel="stylesheet" href="/static/css/nivo-slider.css" type="text/css" media="screen" />
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
           }
    </style>
    <link href="/static/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="/static/ico/favicon.ico">

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/static/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/static/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/static/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/static/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="/">Flicky</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="/">Home</a></li>
              <li><a href="http://somit.me/" target="_blank">About Me</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
    <div class="container">
          <div class="hero-unit" height=80px>
            <div class="row">
                <div class="span5 offset1"
                  <h1>Welcome to FLickY</h1>
                  <p>This is a simple platform to maintain your albums.</p> 
                </div>
                <div class="span4">
                  <a class="btn btn-primary btn-large" href="/album">Start here! Create your Album </a>
       	        </div>
       	     </div>      
          </div>
     </div> 
<!-- ================================================================== -->

   <div class="container">
		<!-- slideshow images -->
		<div class="slideshow"> 
		   <ul> 
			  <li><img src="/static/test/1.jpg" alt="lemon   "  /></li>
			  <li><img src="/static/test/2.jpg" alt="lemon tea" /></li>
			  <li><img src="/static/test/4.jpg" alt="salad w  "/></li>
			  <li><img src="/static/test/5.jpg" alt="lemonade!" /></li>
		   </ul> 
		</div> 

		<!-- change image links -->
		<a href="#" class="change_link" onclick="$('.slideshow').blinds_change(0)">1</a>
		<a href="#" class="change_link" onclick="$('.slideshow').blinds_change(1)">2</a>
		<a href="#" class="change_link" onclick="$('.slideshow').blinds_change(2)">3</a>
		<a href="#" class="change_link" onclick="$('.slideshow').blinds_change(3)">4</a>
		</div>      
<!-- ================================================================== -->
    <div class="container"><!--container 1-->
            <div class="row">
                <div class="span8"> 
                         
                     <h2>ALBUM LIST</h2>   
                        <!---Album list here --->
                        <#list album as key>
                               <div class="row">
						        <div class="span2"><a href="/albums/${key.uid}">${key.name}</a></div>
                                <div class="span2"><a href="/albums/${key.uid}"> ${key.creationDate}</a></div>
 	 			       			<div class="span2"><a href="/albums/${key.uid}"> ${key.description}</a></div>	
 	 			       		   </div>	
                        </#list>   
                  </div>
                  
         				<div class="span4">        
           					<h2>Recent Images</h2>
           					<#include "/sidebar.ftl">
         				</div>

          </div>
    </div> <!-- /container1 -->
 
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/bootstrap-transition.js"></script>
    <script src="/static/js/bootstrap-alert.js"></script>
    <script src="/static/js/bootstrap-modal.js"></script>
    <script src="/static/js/bootstrap-dropdown.js"></script>
    <script src="/static/js/bootstrap-scrollspy.js"></script>
    <script src="/static/js/bootstrap-tab.js"></script>
    <script src="/static/js/bootstrap-tooltip.js"></script>
    <script src="/static/js/bootstrap-popover.js"></script>
    <script src="/static/js/bootstrap-button.js"></script>
    <script src="/static/js/bootstrap-collapse.js"></script>
    <script src="/static/js/bootstrap-carousel.js"></script>
    <script src="/static/js/bootstrap-typeahead.js"></script>
    <script language="Javascript" type="text/javascript" src="/static/js/jquery-1.4.1.js"></script>
	<script language="Javascript" type="text/javascript" src="/static/js/jquery.blinds-0.9.js"></script>
     <script type="text/javascript">
$(window).load(function () {
$('.slideshow').blinds();
})
</script>
  </body>
</html>
