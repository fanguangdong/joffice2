Ext.ns("App");
var PortalItem = function(a, b, c) {
	this.panelId = a;
	this.column = b;
	this.row = c;
};
var SectionItem = function(c, b, a) {
	this.sectionId = c;
	this.colNumber = b;
	this.rowNumber = a;
};
var UserInfo = function(a) {
	this.userId = a.userId;
	this.username = a.username;
	this.fullname = a.fullname;
	this.depId = a.depId;
	this.depName = a.depName;
	this.rights = a.rights;
	this.portalConfig = a.items;
	this.topModules = a.topModules;
};
var SysConfig = function(a) {
	this.dynamicPwd = a.dynamicPwd;
};
var curUserInfo = null;
var sysConfigInfo = null;
function isGranted(a) {
	if (curUserInfo.rights.indexOf("__ALL") != -1) {
		return true;
	}
	if (curUserInfo.rights.indexOf(a) != -1) {
		return true;
	}
	return false;
}
App.init = function() {
	Ext.QuickTips.init();
	Ext.BLANK_IMAGE_URL = __ctxPath + "/ext3/resources/images/default/s.gif";
	setTimeout(function() {
				Ext.get("loading").remove();
				Ext.get("loading-mask").fadeOut({
							remove : true
						});
				document.getElementById("app-header").style.display = "block";
			}, 1000);
	Ext.util.Observable.observeClass(Ext.data.Connection);
	Ext.data.Connection.on("requestcomplete", function(g, h, f) {
				if (h && h.getResponseHeader) {
					if (h.getResponseHeader("__timeout")) {
						Ext.ux.Toast.msg("操作提示：", "操作已经超时，请重新登录!");
						window.location.href = __ctxPath + "/index.jsp?randId="
								+ parseInt(1000 * Math.random());
					} else {
						if (h.getResponseHeader("__403_error")) {
							Ext.ux.Toast.msg("系统访问权限提示：", "你目前没有权限访问：{0}",
									f.url);
						}
					}
				}
			});
	Ext.data.Connection.on("requestexception", function(g, h, f) {
				if (h && h.getResponseHeader) {
					if (h.getResponseHeader("__500_error")) {
						Ext.ux.Toast.msg("后台出错", "您访问的URL:{0}出错了，具体原因请联系管理员。",
								f.url);
					} else {
						if (h.getResponseHeader("__404_error")) {
							Ext.ux.Toast.msg("后台出错",
									"您访问的URL:{0}对应的页面不存在，具体原因请联系管理员。", f.url);
						}
					}
				}
			});
	var d = Ext.util.JSON.decode(userInfo);
	var b = d.user;
	var c = b.items;
	curUserInfo = new UserInfo(b);
	var e = d.sysConfigs;
	sysConfigInfo = new SysConfig(e);
	var a = new IndexPage();
	App.clickTopTab("ComIndexPage");
};
App.clickTopTab = function(g, d, a, f) {
	if (a != null) {
		a.call(this);
	}
	var c = g;
	if (g.indexOf("_") != -1) {
		c = g.split("_")[0];
	}
	var b = Ext.getCmp("centerTabPanel");
	var e = b.getItem(g);
	if (e == null) {
		$ImportJs(c, function(h) {
					e = b.add(h);
					b.activate(e);
				}, d);
	} else {
		if (f != null) {
			f.call(this);
		}
		b.activate(e);
	}
};
App.clickTopTabIframe = function(b) {
	if (b.id == null || b.id == "" || b.id.indexOf("xnode") != -1) {
		return;
	}
	var a = Ext.getCmp("centerTabPanel");
	var c = a.getItem(b.id);
	if (c == null) {
		c = a.add({
					xtype : "iframepanel",
					title : b.text,
					id : b.id,
					loadMask : {
						msg : "正在加载...,请稍等..."
					},
					iconCls : b.attributes.iconCls,
					defaultSrc : __ctxPath + "/pages/iframe/"
							+ b.attributes.model + "/" + b.id + ".jsp?id="
							+ Math.random(),
					listeners : {
						domready : function(d) {
						}
					}
				});
	}
	a.activate(c);
};
App.clickTopTabUrl = function(c) {
	if (c.id == null || c.id == "" || c.id.indexOf("xnode") != -1) {
		return;
	}
	var b = Ext.getCmp("centerTabPanel");
	var a = c.attributes.url;
	if (!(a.substring(0, 4) == "http")) {
		a = __ctxPath + a;
	}
	alert(a);
	var d = b.getItem(c.id);
	if (d == null) {
		d = b.add({
					xtype : "iframepanel",
					title : c.text,
					id : c.id,
					loadMask : {
						msg : "正在加载...,请稍等..."
					},
					iconCls : c.attributes.iconCls,
					defaultSrc : a,
					listeners : {
						domready : function(e) {
						}
					}
				});
	}
	b.activate(d);
};
App.clickStartFlow = function(b) {
	var c = App.getContentPanel();
	var a = c.getItem("ProcessRunStart" + b.attributes.defId);
	if (a == null) {
		a = new ProcessRunStart({
					id : "ProcessRunStart" + b.attributes.defId,
					defId : b.attributes.defId,
					flowName : b.attributes.flowName
				});
		c.add(a);
	}
	c.activate(a);
};
App.clickFLowNode = function(b) {
	var a = [__ctxPath + "/js/archive/ArchivesDetailWin.js",
			__ctxPath + "/js/archive/ArchHastenForm.js",
			__ctxPath + "/js/flow/ProcessNextForm.js",
			__ctxPath + "/js/flow/ProcessRunDetail.js"];
	$ImportSimpleJs(a, null);
	var d = App.getContentPanel();
	var c = d.getItem(b.id);
	if (c == null) {
		c = new ArchivesNode({
					id : "ProcessRunStart" + b.id,
					title : b.attributes.text
				});
		d.add(c);
	}
	d.activate(c);
};
App.clickNode = function(f) {
	if (f.id == null || f.id == "" || f.id.indexOf("xnode") != -1) {
		return;
	}
	var d = f.id;
	var j = f.text;
	if (d.indexOf("?") > 0) {
		var h = d.split("?");
		var a = "";
		if (h.length > 0) {
			d = h[0];
			var k = h[1];
			var b = k.split("&");
			for (i = 0; i < b.length; i++) {
				var g = b[i];
				var e = g.split("=");
				var c = e[0];
				var l = e[1];
				a += c + ":'" + l + "',";
			}
			a += "title:'" + j + "'";
			a = "{" + a + "}";
		}
		if (f.attributes.url) {
			App.clickTopTabUrl(f);
		} else {
			if (f.attributes.iframe) {
				App.clickTopTabIframe(f);
			} else {
				if (f.attributes.defId) {
					App.clickStartFlow(f);
				} else {
					if (f.attributes.flowNode) {
						App.clickFLowNode(f);
					} else {
						App.clickTopTab(d, Ext.decode(a));
					}
				}
			}
		}
	} else {
		if (f.attributes.url) {
			App.clickTopTabUrl(f);
		} else {
			if (f.attributes.iframe) {
				App.clickTopTabIframe(f);
			} else {
				if (f.attributes.defId) {
					App.clickStartFlow(f);
				} else {
					if (f.attributes.flowNode) {
						App.clickFLowNode(f);
					} else {
						App.clickTopTab(f.id, Ext.decode(f.attributes.params));
					}
				}
			}
		}
	}
};
App.MyDesktopClick = function() {
	var a = Ext.getCmp("MyDesktop");
	if (a != null) {
		a.expand(true);
	}
	App.clickTopTab("ComIndexPage");
};
App.MyDesktopClickTopTab = function(id, params, precall, callback) {
	if (precall != null) {
		precall.call(this);
	}
	var tabs = Ext.getCmp("centerTabPanel");
	var tabItem = tabs.getItem(id);
	if (tabItem == null) {
		$ImportJs(id, function(view) {
					tabItem = tabs.add(view);
					tabs.activate(tabItem);
				}, params);
	} else {
		tabs.remove(tabItem);
		var str = "new " + id;
		if (params != null) {
			str += "(params);";
		} else {
			str += "();";
		}
		var view = eval(str);
		tabItem = tabs.add(view);
		tabs.activate(tabItem);
	}
};
App.Logout = function() {
	Ext.Ajax.request({
				url : __ctxPath + "/j_logout.do",
				success : function() {
					deleteCookie("jforumSSOCookieNameUser", "/", 0);
					window.location.href = __ctxPath + "/login.jsp";
				}
			});
};
Ext.onReady(App.init);