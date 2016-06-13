<html>
	<head>
		<title><?php if(isset($title)) echo $title; ?>| Govind learning</title>
		<meta name='author' content='Govind and Vikas'>
		<meta name='description' content='Vikas teaching Govind how to code a little bit'>
		<link rel="stylesheet" type="text/css" href="styles.css" media="screen" />
	</head>
	<body>
		<div id='nav' class='navMenu'>
			<center>
				<ul>
					<li <?php if(isset($tab)){if($tab == "home") echo "class='active'";}?>><a href='index.php'>Home</a></li>
					<li <?php if(isset($tab)){if($tab == "products") echo "class='active'";}?>><a href='products.php'>Products</a></li>
					<li <?php if(isset($tab)){if($tab == "about") echo "class='active'";}?>><a href='about.php'>About</a></li>
					<li <?php if(isset($tab)){if($tab == "contact") echo "class='active'";}?>><a href='contact.php'>Contact</a></li>
				</ul>
			</center>
		</div>
		<div id='container'>
		</div>
	</body>
<?php
//Nav is fixed
//Has a gradient background color <nav>

?>
</html> 