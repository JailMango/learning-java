// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: demo.proto

package cc.protobuf.model;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cc.protobuf.Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 id = 2;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>string emial = 3;</code>
   * @return The emial.
   */
  java.lang.String getEmial();
  /**
   * <code>string emial = 3;</code>
   * @return The bytes for emial.
   */
  com.google.protobuf.ByteString
      getEmialBytes();

  /**
   * <code>repeated .cc.protobuf.Person.PhoneNumber phone = 4;</code>
   */
  java.util.List<cc.protobuf.model.Person.PhoneNumber> 
      getPhoneList();
  /**
   * <code>repeated .cc.protobuf.Person.PhoneNumber phone = 4;</code>
   */
  cc.protobuf.model.Person.PhoneNumber getPhone(int index);
  /**
   * <code>repeated .cc.protobuf.Person.PhoneNumber phone = 4;</code>
   */
  int getPhoneCount();
  /**
   * <code>repeated .cc.protobuf.Person.PhoneNumber phone = 4;</code>
   */
  java.util.List<? extends cc.protobuf.model.Person.PhoneNumberOrBuilder> 
      getPhoneOrBuilderList();
  /**
   * <code>repeated .cc.protobuf.Person.PhoneNumber phone = 4;</code>
   */
  cc.protobuf.model.Person.PhoneNumberOrBuilder getPhoneOrBuilder(
      int index);
}