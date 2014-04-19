GoodsApplyForm=Ext.extend(Ext.Window,{formPanel:null,constructor:function(a){Ext.applyIf(this,a);this.initUIComponents();GoodsApplyForm.superclass.constructor.call(this,{layout:"fit",id:"GoodsApplyFormWin",title:"申请表详细信息",iconCls:"menu-goods-apply",width:450,height:300,minWidth:449,minHeight:299,items:this.formPanel,maximizable:true,border:false,modal:true,plain:true,buttonAlign:"center",buttons:this.buttons,keys:{key:Ext.EventObject.ENTER,fn:this.submitRecord,scope:this}});},initUIComponents:function(){this.formPanel=new Ext.FormPanel({url:__ctxPath+"/admin/saveGoodsApply.do",layout:"form",id:"GoodsApplyForm",frame:false,bodyStyle:"padding : 5px;",defaults:{widht:450,anchor:"96%,96%"},formId:"GoodsApplyFormId",defaultType:"textfield",items:[{name:"goodsApply.applyId",id:"applyId",xtype:"hidden",value:this.applyId==null?"":this.applyId},{name:"goodsApply.goodsId",id:"goodsId",xtype:"hidden"},{name:"goodsApply.userId",id:"userId",xtype:"hidden"},{fieldLabel:"申请号",name:"goodsApply.applyNo",id:"applyNo",readOnly:true},{width:"100%",xtype:"container",layout:"column",fieldLabel:"商品名称",style:"padding-left:0px;margin-bottom:4px;",items:[{columnWidth:0.999,xtype:"textfield",name:"inStock.officeGoods.goodsName",id:"goodsName",allowBlank:false,readOnly:true},{xtype:"button",text:"选择商品",iconCls:"btn-select",handler:function(){GoodsSelector.getView(function(d,b){var a=Ext.getCmp("goodsId");a.setValue(d);var c=Ext.getCmp("goodsName");c.setValue(b);},true).show();}},{xtype:"button",text:" 清除记录",iconCls:"reset",handler:function(){var a=Ext.getCmp("goodsId");a.setValue("");var b=Ext.getCmp("goodsName");b.setValue("");}}]},{fieldLabel:"申请日期",name:"goodsApply.applyDate",id:"applyDate",xtype:"datefield",format:"Y-m-d",allowBlank:false,editable:false},{fieldLabel:"申请数量",name:"goodsApply.useCounts",allowBlank:false,xtype:"numberfield",id:"useCounts"},{xtype:"container",layout:"column",fieldLabel:"申请人",style:"padding-left:0px;margin-bottom:4px;",border:true,items:[{columnWidth:0.999,xtype:"textfield",name:"goodsApply.proposer",id:"proposer",allowBlank:false,readOnly:true},{xtype:"button",text:"选择人员",iconCls:"btn-user-sel",handler:function(){UserSelector.getView(function(c,b){var a=Ext.getCmp("proposer");a.setValue(b);Ext.getCmp("userId").setValue(c);},true).show();}},{xtype:"button",text:" 清除记录",iconCls:"reset",handler:function(){var a=Ext.getCmp("proposer");a.setValue("");}}]},{fieldLabel:"审批状态 ",name:"goodsApply.approvalStatus",id:"approvalStatus",xtype:"hidden"},{fieldLabel:"备注",name:"goodsApply.notes",id:"notes",xtype:"textarea"}]});if(this.applyId!=null&&this.applyId!="undefined"){this.formPanel.getForm().load({deferredRender:false,url:__ctxPath+"/admin/getGoodsApply.do?applyId="+this.applyId,method:"post",waitMsg:"正在载入数据...",success:function(f,g){var e=g.result.data.applyDate;var d=Ext.getCmp("applyDate");d.setValue(new Date(getDateFromFormat(e,"yyyy-MM-dd")));var b=g.result.data.officeGoods.goodsId;var a=g.result.data.officeGoods.goodsName;var c=Ext.getCmp("goodsId");var h=Ext.getCmp("goodsName");c.setValue(b);h.setValue(a);},failure:function(a,b){Ext.ux.Toast.msg("编辑","载入失败");}});}this.buttons=[{text:"保存草稿",iconCls:"btn-save",handler:this.saveRecord},{text:"提交审核",iconCls:"btn-ok",handler:this.submitRecord},{text:"取消",iconCls:"btn-cancel",scope:this,handler:function(){this.close();}}];},saveRecord:function(){Ext.getCmp("approvalStatus").setValue(0);var a=Ext.getCmp("GoodsApplyForm");if(a.getForm().isValid()){a.getForm().submit({method:"post",waitMsg:"正在提交数据...",success:function(b,c){Ext.ux.Toast.msg("操作信息","成功保存信息！");Ext.getCmp("GoodsApplyGrid").getStore().reload();Ext.getCmp("GoodsApplyFormWin").close();},failure:function(b,d){var c=d.result.message;Ext.MessageBox.show({title:"操作信息",msg:c==null&&c==""?"信息保存出错，请联系管理员！":c,buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});Ext.getCmp("GoodsApplyFormWin").close();}});}},submitRecord:function(){Ext.getCmp("approvalStatus").setValue(1);var a=Ext.getCmp("GoodsApplyForm");if(a.getForm().isValid()){a.getForm().submit({method:"post",waitMsg:"正在提交数据...",success:function(b,c){Ext.ux.Toast.msg("操作信息","成功保存信息！");Ext.getCmp("GoodsApplyGrid").getStore().reload();Ext.getCmp("GoodsApplyFormWin").close();},failure:function(b,d){var c=d.result.message;Ext.MessageBox.show({title:"操作信息",msg:c==null&&c==""?"信息保存出错，请联系管理员！":c,buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});Ext.getCmp("GoodsApplyFormWin").close();}});}}});