FCKCommands.RegisterCommand("dtextfield",new FCKDialogCommand("dtextfield",FCKLang.TextFieldProp,FCKPlugins.Items["dtextfield"].Path+"fck_dtextfield.html",400,250));var oSItem=new FCKToolbarButton("dtextfield",FCKLang.TextFieldProp,null,null,null,true,51);FCKToolbarItems.RegisterItem("dtextfield",oSItem);FCK.ContextMenu.RegisterListener({AddItems:function(c,a,b){if(b=="INPUT"&&a.getAttribute("isNew")){c.RemoveAllItems();c.AddItem("Cut",FCKLang.Cut,7,FCKCommands.GetCommand("Cut").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("Copy",FCKLang.Copy,8,FCKCommands.GetCommand("Copy").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("Paste",FCKLang.Paste,9,FCKCommands.GetCommand("Paste").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("dtextfield",FCKLang.TextFieldProp,51);}}});