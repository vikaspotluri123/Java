<html>
<?php
$activeTab="home";
$title = "Home";
function randomURLWanted($lengthOfStringTheUserWants)
{
	$URLTheUserGets = generateURL($lengthOfStringTheUserWants);
	echo $URLTheUserGets;
	die(' You chose random');
}
function URLChosen($URLName)
{
	if(uploadImage($URLName))
	{
		$imageName = $imageFileName;
		// code to build the file they want
	}
	else
	{
		$stuff = error("chosen_fail");
		include('nav.php');
		exit();
	}
}
//Image upload code
function uploadImage($fileName)
{
	$ds = DIRECTORY_SEPARATOR;
	$storeFolder = 'uploads';
	if (!empty($_FILES)) 
	{
	    
		$uploaddir = '../imagehostingbeta/uploads/'; // Relative path under webroot<br />
		$extension = end(explode('.', $_FILES['file']['name']));
		$tempFile = $_FILES['file']['tmp_name'];
		$targetPath = $uploaddir.$fileName.$extension;
		echo $extension;
	    move_uploaded_file($tempFile,$targetPath);
		$imageFileName = $targetPath;
		return true;
	}	
	else return false;
}
//code for random generation of characters
function generateURL($length2)
{
	$string = generateString($length2);
	while(checkIfURLExists($string))
	{
	   $string = generateString($length2);
	}
	return $string;
}
function generateString($length)
{
    $allCharacters=array("0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
    $output="";
    for($i=0;$i<$length;$i++)
        {
            $output = $output . $allCharacters[rand(0, count($allCharacters)-1)];
        }
    return $output;
}
function checkIfURLExists($what)
{
    $array = scandir("../imagehostingbeta"); //CHANGE THIS INTO THE CORRECT DIRECTORY!!!
    if(array_key_exists($what,$array) == true)
       return true;
       return false;
}
function error($what)
{
    if ($what == "customAndChosen")
        return "fatal error! File exists.";
	else if ($what == "Type_is_not_'RANDOM'_or_'CHOSEN'")
		return "Something went wrong! Our fault, please try again.";
	else if($what == 'chosen_fail')
		return "something went wrong! Please upload the image again, or <a href='mailto:webmaster@google.com'>email support</a>.";
}
//sets a default length for the url
$lengthOfString = 10;
//runs the program
if (array_key_exists('check_submit', $_POST)) 
{
	//first thing to do is determine what type of url is wanted
#Name the hidden input that determines what type of url is wanted type. If it's randomly generated, the value should be 'RANDOM'; if it's chosen, the value should be 'CHOSEN'
	if($_POST['type'] == 'RANDOM') {$type='RANDOM'; randomURLWanted($_POST['stringLength']);}
	else if($_POST['type'] == 'CHOSEN'){$type ='CHOSEN'; URLChosen($_POST['urlName']);}
	else {$stuff = error("Type_is_not_'RANDOM'_or_'CHOSEN'"); include('nav.php'); die();} // If the program doesn't work it ends here.
}
else
{
	$stuff="<form method='POST' action='index_new.php' enctype='multipart/form-data'>
		<input type='hidden' name='check_submit' value='1'>
		<input type='hidden' name='type' value=''>
		<label for='file'>File</label><input type='file' name='file' accept='image/*'><br/>
		<label for='questionAsker'>Would you like to choose the URL for the image?</label><br/>
			<input type='radio' name='questionAsker' value='yes' required >Yes<br/>
				<label for='urlName' class='hidden yes' maxlength='99'> The URL I want is:</label><input type='hidden' name='urlName'>
				<div id='breakerYes'></div>
			<input type='radio' name='questionAsker' value='no' required>No<br/>
				<label for='stringLength' class='hidden'>How long should the URL be?</label><input type='hidden' name='stringLength' step='1' min='0' max='150' value='10' maxlength='3'>
				<div id='breakerNo'></div>
		<input type='submit' onclick='validateForm();'>
	</form>
	<script src='js/form.js' type='text/javascript'></script><!--Put the scrip at the bottom of the page to decrease element load time... this will load last and they can start working on the form.!-->";
	include('nav.php');
}