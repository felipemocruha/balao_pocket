import mongoengine as me


class Destination(me.EmbeddedDocument):
    name = me.StringField()


class Pocket:
    items = me.EmbeddedDocumentListField()


class Date(me.Document):
    day = me.DateTimeField()
    destinations = me.EmbeddedDocumentListField()


class Object(me.EmbeddedDocument):
    name = me.StringField()
