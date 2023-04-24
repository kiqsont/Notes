# JSON Parser

> ## JObject
>
> **JSON Type**: json has null(std::string)、bool(bool)、int(int32_t)、double(double)、string(std::string)、array(std::vector\<JObject>)、object(std::map\<std::string,JObject>) type
>
> use **std::variant<bool_t, int_t, double_t, list_t, dict_t>**(value_t) as json object
>
> JObject **data member**: value_t, TYPE(emun)
>
> **Method**
>
> > *T& Value()* : A generic method to return the real type
> >
> > *void\* value()* : The deep implement for Value, use std::get_if and identify 
> >
> > *string_t to_string()* : serialize JObject

> ## Parser
>
> **From JSON**
>
> > *FromString* : set string that need to deserialize
> >
> > *char get_next_token* : get the next vaild char
> >
> > *Parse()* : call different method to parse
>
> **To JSON**
>
> > call JObject::to_string()
>
> **Macro**
>
> > from(key,type)
> >
> > from_array(key,arr_type)
> >
> > from_struct(key,struct_member)
> >
> > to(key)
> >
> > to2(key,struct_member)
> >
> > to(key,struct_member)
> >
> > to_array(key,struct_member)



