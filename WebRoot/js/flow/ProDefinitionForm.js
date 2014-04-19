var ProDefinitionForm=function(a,b){this.defId=a;this.typeId=b;this.setup();var c=new Ext.Window({id:"ProDefinitionFormWin",title:"流程定义详细信息",iconCls:"menu-flowNew",width:500,height:420,modal:true,layout:"anchor",plain:true,bodyStyle:"padding:5px;",buttonAlign:"center",items:[this.formPanel],buttons:[{text:"保存并发布",iconCls:"btn-save",handler:function(){var d=Ext.getCmp("ProDefinitionForm");if(d.getForm().isValid()){d.getForm().submit({method:"post",params:{deploy:true},waitMsg:"正在提交数据...",success:function(e,f){Ext.ux.Toast.msg("操作信息","成功信息保存！");Ext.getCmp("ProDefinitionGrid").getStore().reload();c.close();},failure:function(e,f){Ext.MessageBox.show({title:"操作信息",msg:"信息保存出错，请联系管理员！",buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});}});}}},{iconCls:"btn-cancel",text:"取消",handler:function(){c.close();}}]});c.show();};ProDefinitionForm.prototype.setup=function(){var c=this.typeId;var b=__ctxPath+"/flow/listProType.do";this.formPanel=new Ext.FormPanel({url:__ctxPath+"/flow/saveProDefinition.do",layout:"form",id:"ProDefinitionForm",frame:true,defaults:{widht:400,anchor:"96%,96%"},formId:"ProDefinitionFormId",defaultType:"textfield",items:[{name:"proDefinition.defId",xtype:"hidden",value:this.defId==null?"":this.defId},{xtype:"compositefield",fieldLabel:"流程类型",items:[{name:"proDefinition.proTypeName",xtype:"textfield",width:250,readOnly:true,allowBlank:false},{xtype:"button",text:"选择类型",iconCls:"btn-select",scope:this,handler:function(){var d=this.formPanel;new GlobalTypeSelector({catKey:"FLOW",isSingle:true,callback:function(f,e){d.getCmpByName("proDefinition.proTypeId").setValue(f);d.getCmpByName("proDefinition.proTypeName").setValue(e);}}).show();}}]},{fieldLabel:"流程状态",hiddenName:"proDefinition.status",xtype:"combo",allowBlank:false,editable:false,mode:"local",triggerAction:"all",store:[["0","禁用"],["1","激活"]],value:1},{xtype:"hidden",id:"proTypeId",name:"proDefinition.proTypeId"},{fieldLabel:"流程的名称",name:"proDefinition.name"},{fieldLabel:"描述",xtype:"textarea",name:"proDefinition.description"},{fieldLabel:"流程定义的XML",name:"proDefinition.defXml",xtype:"textarea",height:200}]});var a=(this.defId==null||this.defId=="undefined")?"":this.defId;var c=(this.typeId==null||this.typeId=="undefined")?"":this.typeId;this.formPanel.loadData({url:__ctxPath+"/flow/getProDefinition.do?defId="+a+"&proTypeId="+c,root:"data",preName:"proDefinition",scope:this,success:function(e,h){var d=Ext.util.JSON.decode(e.responseText);if(d){var g=d.data.proType;if(g!=null){this.formPanel.getCmpByName("proDefinition.proTypeName").setValue(g.typeName);this.formPanel.getCmpByName("proDefinition.proTypeId").setValue(g.proTypeId);}var f=d.data.deployId;if(f){this.formPanel.getCmpByName("proDefinition.name").getEl().dom.readOnly=true;}}}});return this.formPanel;};