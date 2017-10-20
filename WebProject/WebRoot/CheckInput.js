/*
 * Check ck = new Check();
 * bool bln = ck.checkDate("2015/02/03");
 * 
 * 上面的代码在JavaScript里面可以这样写吗？
 * 
 * 
 * */

function CheckInput()  //模拟Java里面的类
{
	this.checkDate = checkDate;
	this.checkEmpty = checkEmpty;
	
	function checkDate( date )
	{
		try
		{    			
			var result = Date.parse(date);
			
			//isNaN ==> 是不是    不是一个数字  true或者false 
			if( isNaN(result) == true)
			{
				return false;
			}
		}catch (e) {
			return false;
		}	
		
		return true;
	}

	function checkEmpty( value )
	{
		return value.length == 0 ? false : true;
	}	
}
function popup( div )
{
	//通过 本元素找到 隔壁元素		
	var li = div.parentNode;
	var ul = li.getElementsByTagName("ul")[0];
	
	if(ul.style.display == "block" )
	{
		ul.style.display = "none";	
	}else
	{
		ul.style.display = "block";
	}
}