function send_message(){	
	var content=$("textarea[name=content]").val();
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	var publisher=$("input[name=publisherMail]").val()
	if(content.length==0||re.test(content)){
		alert("�������ݲ���Ϊ�գ�");
	}else if(publisher.length==0){
		alert("���¼�Ժ��������ԣ�")
	}
	else{
		alert("�ɹ�����")
		var params = $("#messageForm").serialize();  
		 $.ajax({  
             url:"addMessage",  
             type:"POST",  
             data:params,  
             dataType:"json",  
             success:function(data){  
               alert(data);
               }
         });  
	}
}