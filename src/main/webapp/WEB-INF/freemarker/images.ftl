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
          <a class="brand" href="/">FLICKY</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="/">Home</a></li>
              <li ><a href="/album">Create Album</a></li>
              <li class="active"><a href="http://somit.me/" target="_blank">About Me</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>

      </div>
    </div>
    <div class="span6 offset2">
        <h1>${album.name}</h1> <br /> 
        </div>
          <div class="container">
           <div class="row">
           <div class="span12">        
 
        
    </div> <!-- /container -->

               <div class="container">
              <div class="row">
        <div class="span6">  

 
     <div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">
    <div class="active item"><a href="#"class="thumbnail"><img src="/static/images/${singleImage.album.uid}/${singleImage.name}" alt="Image Lost" width="600" height="400"></a></div>
    </div>
    <a class="carousel-control left" href="/images/${prev.id}" data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="/images/${next.id}" data-slide="next">&rsaquo;</a>
   </div>
        <h3>${singleImage.name} &nbsp;&nbsp;&nbsp;&nbsp;${singleImage.date}<h3>   
   
        <script type="text/javascript">
   	 		$('.carousel').carousel({
    		interval: 2000
    		})
			</script>
   
         </div>
   
                       <div class="row">
        <div class="span4 offset2">
     <div id= "mycom1">
       <h2>     Comments:   </h2><br />
    
          <ul>
            <#list singleImage.comments as key>
                <li><h3>${key}</h3></li>	
            </#list>
            <div id="mycom"></div>
         </ul>
   </div>
   
     
      
 <script src="/static/js/jquery-latest.js"></script>
  <form action="/comments/${singleImage.id}" id="searchForm" method="post">
   <input type="text" name="comment" placeholder="Comment..." /><br />
   <input type="submit" value="Comment" />
  </form>

  </div>
<script>
  /* attach a submit handler to the form */
  $("#searchForm").submit(function(event) {
    event.preventDefault(); 
        
    var $form = $( this ),
        term = $form.find( 'input[name="comment"]' ).val(),
        url = $form.attr( 'action' );
      $.post( url, { newComment: term },
      function() {
         	var newdiv=document.createElement("li")
         	var newdiv1=document.createElement("h3")
			var newtext=document.createTextNode(term)
			newdiv1.appendChild(newtext) //append text to new div
			newdiv.appendChild(newdiv1)
			document.getElementById("mycom").appendChild(newdiv)
      }
    );
  });
</script>





         
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
