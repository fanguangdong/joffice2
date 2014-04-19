var ProjectSelector={getView:function(h,f){var g=null;if(f){var g=new Ext.grid.CheckboxSelectionModel({singleSelect:true});}else{g=new Ext.grid.CheckboxSelectionModel();}var b=new Ext.grid.ColumnModel({columns:[g,new Ext.grid.RowNumberer(),{header:"projectId",dataIndex:"projectId",hidden:true},{header:"项目编号",dataIndex:"projectNo",width:60},{header:"项目名称",dataIndex:"projectName",width:60},{header:"所属客户",dataIndex:"customer",width:60,renderer:function(i){return i.customerName;}},{header:"联系人",dataIndex:"fullname",width:60},{header:"项目描述",dataIndex:"reqDesc",hidden:true}]});var c=new Ext.data.Store({proxy:new Ext.data.HttpProxy({url:__ctxPath+"/customer/listProject.do"}),reader:new Ext.data.JsonReader({root:"result",totalProperty:"totalCounts",id:"projectId",fields:[{name:"projectId",type:"int"},"projectNo","projectName","customer","fullname","reqDesc"]}),remoteSort:true});var d=new Ext.grid.GridPanel({id:"ProjectSelectorGrid",width:400,height:300,region:"center",title:"项目列表",store:c,shim:true,trackMouseOver:true,disableSelection:false,loadMask:true,cm:b,sm:g,viewConfig:{forceFit:true,enableRowBody:false,showPreview:false},bbar:new HT.PagingBar({store:c})});c.load({params:{start:0,limit:25}});var a=new Ext.FormPanel({width:400,region:"north",id:"ProjectForm",height:40,frame:false,border:false,layout:"hbox",layoutConfig:{padding:"5",align:"middle"},defaults:{xtype:"label",margins:{top:0,right:4,bottom:4,left:4}},items:[{text:"查询条件:"},{text:"项目编号"},{xtype:"textfield",width:80,name:"Q_projectNo_S_LK"},{text:"项目名称"},{xtype:"textfield",width:80,name:"Q_projectName_S_LK"},{xtype:"button",text:"查询",iconCls:"search",handler:function(){var i=Ext.getCmp("ProjectForm");var j=Ext.getCmp("ProjectSelectorGrid");if(i.getForm().isValid()){i.getForm().submit({waitMsg:"正在提交查询",url:__ctxPath+"/customer/listProject.do",success:function(l,m){var k=Ext.util.JSON.decode(m.response.responseText);j.getStore().loadData(k);}});}}}]});var e=new Ext.Window({title:"项目选择器",iconCls:"menu-project",width:430,height:380,layout:"border",border:false,items:[a,d],modal:true,buttonAlign:"center",buttons:[{iconCls:"btn-ok",text:"确定",handler:function(){var n=Ext.getCmp("ProjectSelectorGrid");var o=n.getSelectionModel().getSelections();var l="";var k="";var j="";for(var m=0;m<o.length;m++){if(m>0){l+=",";k+=",";j+=",";}l+=o[m].data.projectId;k+=o[m].data.projectName;j+=o[m].data.projectNo;}if(h!=null){h.call(this,l,k,j);}e.close();}},{text:"取消",iconCls:"btn-cancel",handler:function(){e.close();}}]});return e;}};