Ext.ns("UserJobDetailForm");UserJobDetailForm.show=function(a,c){var b=new Ext.Window({title:"员工["+c+"]职位信息",iconCls:"menu-job",width:480,height:200,minHeight:200,maximizable:true,modal:true,layout:"form",buttonAlign:"center",autoLoad:{url:__ctxPath+"/pages/system/UserJobDetailView.jsp?userId="+a},buttons:[{xtype:"button",iconCls:"btn-close",text:"关闭",handler:function(){b.close();}}],keys:{key:Ext.EventObject.ENTER,fn:function(){b.close();},scope:this}});b.show();};