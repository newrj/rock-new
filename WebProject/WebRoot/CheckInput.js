/*
 * Check ck = new Check();
 * bool bln = ck.checkDate("2015/02/03");
 * 
 * ����Ĵ�����JavaScript�����������д��
 * 
 * 
 * */

function CheckInput()  //ģ��Java�������
{
	this.checkDate = checkDate;
	this.checkEmpty = checkEmpty;
	
	function checkDate( date )
	{
		try
		{    			
			var result = Date.parse(date);
			
			//isNaN ==> �ǲ���    ����һ������  true����false 
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
	//ͨ�� ��Ԫ���ҵ� ����Ԫ��		
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