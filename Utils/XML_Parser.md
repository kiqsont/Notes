# XML Parser Tool Note

## Element Class
name(string) for Element name like \<objName/>  
text(string) for Element text like \<obj>objText\</obj>
children(vector\<Element>) for Sub Element    
attrs(map\<string,string>) for attritubes like \<obj attr1="v">    
    
has to_string() to serialize


## Parser Class
LoadFile or LoadString function to set the string which need to be parse    

**Parse Flo** :    
Parse() => parse version,comment or parse to Element and return    
for parse_version¡¢ parse_comment and parse_element    
    

> parse_element    
>
> > => parse element name    
>> parse single element   

>> '<' parse end tag¡¢comment¡¢ next element   
>>> - end tag like \</aName>   
>>> - for comment to find "-->"
>>> - push the Parse() return to children_    

>> '>' for current tag end and start the next parse   
>>> start the next parse or set the text   
>> parse the attributes
