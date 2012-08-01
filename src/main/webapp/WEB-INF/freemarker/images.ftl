<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Flicky from Hashedin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Flicky Application">
    <meta name="author" content="Somit">

    <!-- Le styles -->
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
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="/">Flicky</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="/">Home</a></li>
              <li><a href="http://somit.me/">About Me</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>

      </div>
    </div>
    <div class="span6 offset2">
        <h1>Album Name: ${album.name}</h1> <br /> 
        </div>
      
          <div class="container">
           <div class="row">
           <div class="span12">        
   	 <div class="btn-group">
   	 <a class="btn" rel="Previous Image" title=${prev.name} href="/images/${prev.id}">prev</a>
   	 <a class="btn" rel="Next Image" title=${next.name} href="/images/${next.id}">next</a>
   	 </div> 
         </div>
    </div> <!-- /container -->

               <div class="container">
              <div class="row">
        <div class="span6">  

        <h2>Image:${singleImage.name} &nbsp;&nbsp;&nbsp;&nbsp; Date: ${singleImage.date}<h2>    
          <a href="#"class="thumbnail">
          <img src="/static/images/${singleImage.album.uid}/${singleImage.name}" alt="Image" width="600" height="400">   </a>  
         </div>
   
                       <div class="row">
        <div class="span4 offset2">
     
       <h2>     Comments:   </h2>
       <h2>   -----------------------------------------------</h2>
         <#list singleImage.comments as key>       
 	      <li>
       <h3>${key}</h3>
         </a>
         </li>
         </#list>
         <h2>   -----------------------------------------------</h2>
              <form name="user" action="/comments/${singleImage.id}" method="post">
              <input type="text" name="comment" /><br/>
                 <input type="submit" value="Comment" />
            </form>  
         
         
         
         </div>
         
    </div> <!-- /container -->\

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

  </body>
</html>
