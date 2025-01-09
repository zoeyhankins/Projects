(function(window, undefined) {
  var dictionary = {
    "afbbf68c-d31e-421d-b9e2-7df4e98f63cb": "Lodging",
    "e76e2266-eaee-4ca7-9800-083cf1c780a1": "FAQs",
    "d12245cc-1680-458d-89dd-4f0d7fb22724": "Home",
    "45e73bb3-4129-4d6d-bdf7-5c545b6ee93b": "Grocery Stores & Restaurants",
    "dcf166a6-30c7-44cc-b035-11e6cdf212ba": "Entertainment",
    "f39803f7-df02-4169-93eb-7547fb8c961a": "Template 1",
    "bb8abf58-f55e-472d-af05-a7d1bb0cc014": "Board 1"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);