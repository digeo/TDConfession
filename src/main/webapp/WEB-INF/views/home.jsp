<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/resources/assets/images/favicon.png" />">

    <title>Technical Debt Confession | Rijksuniversiteit Groningen</title>

    <!-- Bootstrap core CSS -->
    <link type="text/css" href="<c:url value="/resources/assets/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link type="text/css" href="<c:url value="/resources/assets/css/ie10-viewport-bug-workaround.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link type="text/css" href="<c:url value="/resources/assets/css/jumbotron-narrow.css" />" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<c:url value="/resources/assets/js/ie-emulation-modes-warning.js" />"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <div class="header clearfix">
<!--         <nav> -->
<!--           <ul class="nav nav-pills pull-right"> -->
<!--             <li role="presentation" class="active"><a href="#">Home</a></li> -->
<!--             <li role="presentation"><a href="#">About</a></li> -->
<!--             <li role="presentation"><a href="#">Contact</a></li> -->
<!--           </ul> -->
<!--         </nav> -->
        <h3 class="text-muted">Technical Debt Confession</h3>
      </div>

      <div class="jumbotron">
        <h1>Heading</h1>
        <p class="lead">Intro text here!</p>
<!--         <p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p> -->
      </div>

      <div class="row marketing">
      
        <div class="col-lg-6">
        <c:forEach var="confession" items="${leftConfessions}">
          <div class="panel panel-default">
          	<div class="panel-body"><h4>${confession.confessionText}</h4></div>
          	<div class="panel-footer">
          	<a href="${pageContext.request.contextPath}/thumbsUp/${confession.id}" class="btn btn-success" role="button">
          		<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span> <span class="badge">${confession.possitiveVotes}</span>
          	</a>
          	<a href="${pageContext.request.contextPath}/thumbsDown/${confession.id}" class="btn btn-danger" role="button">
          		<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span> <span class="badge">${confession.negativeVotes}</span>
          	</a>
          	</div>
          </div>
          </c:forEach>
        </div>

        <div class="col-lg-6">
          <c:forEach var="confession" items="${rightConfessions}">
          <div class="panel panel-default">
          	<div class="panel-body"><h4>${confession.confessionText}</h4></div>
          	<div class="panel-footer">
          	<a href="${pageContext.request.contextPath}/thumbsUp/${confession.id}" class="btn btn-success" role="button">
          		<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span> <span class="badge">${confession.possitiveVotes}</span>
          	</a>
          	<a href="${pageContext.request.contextPath}/thumbsDown/${confession.id}" class="btn btn-danger" role="button">
          		<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span> <span class="badge">${confession.negativeVotes}</span>
          	</a>
          	</div>
          </div>
          </c:forEach>
        </div>
        
      </div>
      
      <br>
      
      <form:form method="post" action="${pageContext.request.contextPath}/">
	 <div class="row">
		    <div class="input-group">
		      <input type="text" name="confessionText" id="confessionText" class="form-control" placeholder="Confession">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="submit">Amen! <span class="glyphicon glyphicon-send" aria-hidden="true"></span></button>
<!-- 		        <input class="btn btn-success" type="submit" value="Submit"> -->
		      </span>
		    </div><!-- /input-group -->
	  </div><!-- /.row -->
	  </form:form>
	  
	  <br>
      
      <footer class="footer">
        <p>&copy; 2016 <a href="http://www.rug.nl/" target="_blank">Rijksuniversiteit Groningen</a> - <a href="http://www.cs.rug.nl/search/" target="_blank">SEARCH Group</a>, <a href="mailto:digasgeo@yahoo.gr?Subject=Technical%20Debt%20Confession" target="_top">Georgios Digkas</a></p>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<c:url value="/resources/assets/js/ie10-viewport-bug-workaround.js" />"></script>
  </body>
</html>

