package com.example.domain.states

sealed class DataStates
open class DataResponseError(var cause: Throwable? = null) : DataStates()

open class DataResponseSuccess : DataStates()
open class EmptyState : DataStates()
open class EmailStates : DataStates()
open class AllDataStates : DataStates()
open class AuthStates : DataStates()
open class PasswordResetStates : DataStates()
open class ProductStates : DataStates()
open class POSStates : DataStates()
open class InvoiceStates : DataStates()
open class SettingsStates : DataStates()
open class CustomerStates : DataStates()
open class CategoryStates : DataStates()
open class PaymentStates : DataStates()
open class RegisterStates : DataStates()
open class StoreStates : DataStates()
open class TransferOrderStates : DataStates()
open class DashboardReportStates : DataStates()
open class OnlineOrderStates : DataStates()
open class SalesTicketStates : DataStates()
open class RefreshingState : DataStates()