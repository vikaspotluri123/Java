<html>
<?php
$activeTab="home";
$title = "Home";
//code for random generation of characters
function generateURL($length)
{
	generateString($length);
	while(checkIfURLExists($url))
	{
	   generateString($length);
	}
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
    if(array_key_exists($url,$array) == true)
       return true;
       return false;
}
function error($what)
{
    if ($what == "customAndChosen");
        return "fatal error! File exists.";
}
//sets a default length for the url
$lengthOfString = 10;
//runs the program
if (array_key_exists('check_submit', $_POST)) 
{
    // $index = file_get_contents('base.php');
	if($_POST['what_type'] == 'picked')
		{
			$lengthofString = $_POST['ifURLIMake'];
			$url = generateURL($lengthOfString);
			echo $url; // debug :)
		}
		else if($_POST['what_type'] == 'chosen')
		{
			if(checkIfURLExists($_POST['ifURLChoosen']))
			{
				$url = $_POST['ifURLChoosen'];
			}
			else error("FileExists");
		}
	echo $url;
	if(isset($url))
	{
		echo $url;
	$variable = fopen($url,'w');
	fwrite($variable,'why');
	fclose($variable);
    	
	}
	    //Create a file named index.php with the contents of $index
        ##get the image
        #Checks if the file "works" ( If it doesn't...)
    if ($_FILES["file"]["error"] > 0)
        echo "The file didn't upload properly. Please try again";
        #If the file does work...
    else
        {
            #Moves the uploaded file to the server
               move_uploaded_file($_FILES["file"]["tmp_name"],"/".$url."/image.");
        }
        }
else
    {
        $stuff = "<form action='index.php' method ='POST' enctype='multipart/form-data' onsubmit='return validateForm()'>
					<input type='hidden' name='check_submit' value='1'>
					<input type='hidden' name='what_type' value='' id='what_type'>
					<p><label for='name'>Name</label><input type='text' name='name'></p>
					<p><label for='upload'> File</label><input type='file' name='upload' required><br/></p> <!--File!-->
					   <label for ='myRadio'>Would you like to choose the url for the image?</label><br/><!--Question!-->
					   <input type='radio' name='myRadio' value='yes'class='myRadio'>yes<br/>
					   <label for='ifURLChoosen' class='hidden ifURLChoosenLabel'style='text-indent:5em;'>Enter the custom url you would like:</label><!-- Label!-->
					   <input type='hidden' name='ifURLChoosen' class='ifURLChoosen'><br class='hidden brNo'>
					   <input type='radio' name='myRadio' value='no' id='myRadioNo' class='myRadio'>no<br/>
					   <label for='ifURLIMake' class='hidden ifURLIMakeLabel'style='text-indent:5em;'>How many characters would you like the URL to be? (default is 10, if it doesn't matter leave it blank)</label>
					   <input type='hidden' name='ifURLIMake' class='ifURLIMake' pattern='[0-9]{1,2}'>	<br class='hidden brNoo'/>
					   <input type='checkbox'>This image is not suitable for all ages ('adult content')<br />
					   <input type='checkbox'>I want this image to be kept private.<br />
					   <input type='checkbox' name='toc' id='toc'>I have <a class='not'>not </a>read the <a href='TermsOfService.php'>terms of service</a>
					   	<center><input type='submit' name='submit' value='Get your URL!' ></center>
					</form>
                <script src='js/form.js'></script>
                ";
    include("nav.php");
    }
?>
</html>