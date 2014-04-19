Ext.ns("PlanTypeView");var PlanTypeView=function(){return new Ext.Panel({id:"PlanTypeView",title:"计划类型列表",iconCls:"menu-plantype",layout:"border",region:"center",autoScroll:true,items:[new Ext.FormPanel({id:"PlanTypeSearchForm",region:"north",height:40,frame:false,border:false,layout:"hbox",layoutConfig:{padding:"5",align:"middle"},defaults:{xtype:"label",margins:{top:0,right:4,bottom:4,left:4}},items:[{text:"请输入查询条件:"},{text:"类型名称"},{xtype:"textfield",name:"Q_typeName_S_LK"},{xtype:"button",text:"查询",iconCls:"search",handler:function(){var a=Ext.getCmp("PlanTypeSearchForm");var b=Ext.getCmp("PlanTypeGrid");if(a.getForm().isValid()){$search({searchPanel:a,gridPanel:b});}}},{xtype:"button",text:"重置",iconCls:"btn-reset",handler:function(){var a=Ext.getCmp("PlanTypeSearchForm");a.getForm().reset();}}]}),this.setup()]});};PlanTypeView.prototype.setup=function(){return this.grid();};PlanTypeView.prototype.grid=function(){var d=new Ext.grid.CheckboxSelectionModel();var a=new Ext.grid.ColumnModel({columns:[d,new Ext.grid.RowNumberer(),{header:"typeId",dataIndex:"typeId",hidden:true},{header:"类型名称",dataIndex:"typeName"},{header:"管理",dataIndex:"typeId",width:50,sortable:false,renderer:function(h,g,e,k,f){var j=e.data.typeId;var i="";if(isGranted("_PlanTypeDel")){i='<button title="删除" value=" " class="btn-del" onclick="PlanTypeView.remove('+j+')"></button>';}if(isGranted("_PlanTypeEdit")){i+='&nbsp;<button title="编辑" value=" " class="btn-edit" onclick="PlanTypeView.edit('+j+')"></button>';}return i;}}],defaults:{sortable:true,menuDisabled:false,width:100}});var b=this.store();b.load({params:{start:0,limit:25}});var c=new Ext.grid.GridPanel({id:"PlanTypeGrid",tbar:this.topbar(),store:b,trackMouseOver:true,disableSelection:false,loadMask:true,region:"center",cm:a,sm:d,viewConfig:{forceFit:true,enableRowBody:false,showPreview:false},bbar:new HT.PagingBar({store:b})});c.addListener("rowdblclick",function(g,f,h){g.getSelectionModel().each(function(e){if(isGranted("_PlanTypeEdit")){PlanTypeView.edit(e.data.typeId);}});});return c;};PlanTypeView.prototype.store=function(){var a=new Ext.data.Store({proxy:new Ext.data.HttpProxy({url:__ctxPath+"/task/listPlanType.do"}),reader:new Ext.data.JsonReader({root:"result",totalProperty:"totalCounts",id:"id",fields:[{name:"typeId",type:"int"},"typeName"]}),remoteSort:true});a.setDefaultSort("typeId","desc");return a;};PlanTypeView.prototype.topbar=function(){var a=new Ext.Toolbar({id:"PlanTypeFootBar",height:30,bodyStyle:"text-align:left",items:[]});if(isGranted("_PlanTypeAdd")){a.add(new Ext.Button({iconCls:"btn-add",text:"添加计划类型",handler:function(){new PlanTypeForm();}}));}if(isGranted("_PlanTypeDel")){a.add(new Ext.Button({iconCls:"btn-del",text:"删除计划类型",handler:function(){var d=Ext.getCmp("PlanTypeGrid");var b=d.getSelectionModel().getSelections();if(b.length==0){Ext.ux.Toast.msg("信息","请选择要删除的记录！");return;}var e=Array();for(var c=0;c<b.length;c++){e.push(b[c].data.typeId);}PlanTypeView.remove(e);}}));}return a;};PlanTypeView.remove=function(b){var a=Ext.getCmp("PlanTypeGrid");Ext.Msg.confirm("信息确认","您确认要删除该记录吗？",function(c){if(c=="yes"){Ext.Ajax.request({url:__ctxPath+"/task/multiDelPlanType.do",params:{ids:b},method:"post",success:function(d,f){var e=Ext.util.JSON.decode(d.responseText);if(e.success==false){Ext.ux.Toast.msg("信息提示",e.message);}else{Ext.ux.Toast.msg("信息提示","成功删除所选记录！");a.getStore().reload({params:{start:0,limit:25}});}}});}});};PlanTypeView.edit=function(a){new PlanTypeForm(a);};