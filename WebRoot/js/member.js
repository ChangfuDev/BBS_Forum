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
		var params = $("#messageForm").serialize();  
		 $.ajax({  
             url:"addMessage",  
             type:"POST",  
             data:params,  
             dataType:"json",  
             success:function(data){             	            	     
               if(data.flag==true){            	            	               	            	 
            	   $('.alert').html('�����ɹ���').addClass('alert-success').show().delay(1500).fadeOut();            	  
            	   $("textarea[name=content]").val("");
            	   if($("#myCollection>.art-row").size()==4){
           			  var totalpage=$("#pagefoot>li").size()-2;
           			  var receiverMail=$("input[name=receiverMail]").val();
           			  $("#showLastPage").attr("name","showMessageByPage?page="+totalpage+"&receiverMail="+receiverMail);
           			  $("#showLastPage").trigger("click");
           			}else{
           			 var str;            	  
           			 var temp=data.messages[0];  
           			 var date=temp.publishDate.substring(0,10);
           			 date+=" "+temp.publishDate.substring(11,16);  
           			 str="<div class='art-row'>"	                           
                              +"<h4><a href='' class='title'>"+temp.content+"</a></h4>"+	                          
                               "<a href='http://localhost:8080/BBS_Forum/chaeckUserByUrl?mailAddress="+temp.publisherMail.mailAddress+"' class='author'>"+
                               "<i class='fa fa-user'></i>&nbsp;<span>"+temp.publisherMail.username+"</span></a> <a  class='time'>" +
                               "<i class='fa fa-clock-o'></i>&nbsp;<span>"+date+"</span></a>" 	                          
                          +"</div>";  	
           			}       	        
            	   if(data.messages.length==1){//������غ�������б�ĳ���Ϊ1����������ǵ�һ���������
            		   //alert("���ǵ�һ������")
            		   $("span[name=nomessage]").remove();            		  
            		   $("#messageForm").before(str);
            	   }else{
            		   $("#myCollection>.art-row:first").before(str);
            	   }            	               	              	  	          
               }else{
            	   alert("����ʧ�ܣ�")
               }
             }
         });  
	}
}
function paging(t){
	var url=$(t).attr("name");	
	var receiverMail=$("input[name=receiverMail]").val();
	$.ajax({
		type:"post",
		url:url,
		dataType:"json",
        success:function(data){
        	var str;
        	var date;
        	$("#myCollection>.art-row").remove();
        	$("#pagefoot").remove();
        	$.each(data.pageBean.list,function(index,message){        		
        	   date=message.publishDate.substring(0,10);
     		   date+=" "+message.publishDate.substring(11,16);       		   
        		str="<div class='art-row'>"	                           
                    +"<h4><a href='' class='title'>"+message.content+"</a></h4>"+                          
                     "<a href='http://localhost:8080/BBS_Forum/chaeckUserByUrl?mailAddress="+message.publisherMail.mailAddress+"' class='author'>"+
                     "<i class='fa fa-user'></i>&nbsp;<span>"+message.publisherMail.username+"</span></a> <a  class='time'>" +
                     "<i class='fa fa-clock-o'></i>&nbsp;<span>"+date+"</span></a>" 	                          
                +"</div>";     
        		$("#messageForm").before(str);
        	});
        	var pageBean=data.pageBean;
        	var currentPage=pageBean.currentPage;
        	var pre=currentPage-1;
        	var next=currentPage+1;       
        	str="<ul id='pagefoot' class='pager'>";
        	if(currentPage==1){
        		str+="<li class='disabled'><a>&laquo;</a></li>";        
        	}else{
        		str+="<li><a onclick='paging(this)'  href='javascript:void(0);' name='showMessageByPage?page="+pre+"&receiverMail="+receiverMail+"'>&laquo;</a></li>";        
        	}        		               
        	for(var i=1;i<pageBean.totalPage+1;i++){
        		if(i==currentPage){
        			str+="<li ><a >"+i+"</a></li>";
        		}
        		else{
        			str+="<li><a  href='javascript:void(0);' onclick='paging(this)' name='showMessageByPage?page="+i+"&receiverMail="+receiverMail+"'>"+i+"</a></li>";
        		}        		
        	}
        	if(currentPage==pageBean.totalPage){
        		str+="<li class='disabled'><a>&raquo;</a></li>"+		   
	             "</ul>";	        
        	}else{
        		str+="<li ><a onclick='paging(this)' href='javascript:void(0);' name='showMessageByPage?page="+next+"&receiverMail="+receiverMail+"'>&raquo;</a></li>"+		   
	             "</ul>";	 
        	}	        
	        $("#messageForm").before(str);
        }
	});	
}
function pagingPost(t){
	var url=$(t).attr("name");	
	var publisherMail=$("#myArticle>[name=publisherMail]").val();
	$.ajax({
		type:"post",
		url:url,
		dataType:"json",
        success:function(data){
        	var str;
        	var date;
        	$("#myArticle>.art-row").remove();
        	$("#postpagefoot").remove();        	
        	$.each(data.pageBean.list,function(index,post){         
         	   date=post.publishTime.substring(0,10);
      		   date+=" "+post.publishTime.substring(11,16);        		 
         		str="<div class='art-row'>"	                           
                     +"<h4><a href='' class='title'>"+post.title+"</a></h4>"+
                     "<span class='label label-default'><a href=''>"+post.childboardId.name+"</a></span>"+
                      "<a href='http://localhost:8080/BBS_Forum/chaeckUserByUrl?mailAddress="+post.publisherMail.mailAddress+"'class='author'>"+
                      "<i class='fa fa-user'></i>&nbsp;<span>"+post.publisherMail.username+"</span></a> <a  class='time'>" +
                      "<i class='fa fa-clock-o'></i>&nbsp;<span>"+date+"</span></a>" 	                          
                +"</div>";     
         		$("#myArticle").append(str);
         	});
        	var pageBean=data.pageBean;
        	var currentPage=pageBean.currentPage;
        	var pre=currentPage-1;
        	var next=currentPage+1;         
        	str="<ul id='postpagefoot' class='pager'>";
        	if(currentPage==1){
        		str+="<li class='disabled'><a>&laquo;</a></li>";        
        	}else{
        		str+="<li><a onclick='pagingPost(this)'  href='javascript:void(0);' name='showPostByPage?page="+pre+"&publisherMail="+publisherMail+"'>&laquo;</a></li>";        
        	}            	
        	for(var i=1;i<pageBean.totalPage+1;i++){
        		if(i==currentPage){
        			str+="<li ><a >"+i+"</a></li>";
        		}
        		else{
        			str+="<li><a  href='javascript:void(0);' onclick='pagingPost(this)' name='showPostByPage?page="+i+"&publisherMail="+publisherMail+"'>"+i+"</a></li>";
        		}        		
        	}
        	if(currentPage==pageBean.totalPage){
        		str+="<li class='disabled'><a>&raquo;</a></li>"+		   
	             "</ul>";	        
        	}else{
        		str+="<li ><a onclick='pagingPost(this)' href='javascript:void(0);' name='showPostByPage?page="+next+"&publisherMail="+publisherMail+"'>&raquo;</a></li>"+		   
	             "</ul>";	 
        	}	                
        	$("#myArticle>.art-row:last").after(str);           	
        	}	
        })
}