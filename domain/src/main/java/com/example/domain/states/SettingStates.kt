package com.example.domain.states

data class FailedOperation(val message: String, var data: Any? = null) : SettingsStates()
//data class EmployeeUpdated(val data: TractionEmployee) : SettingsStates()
//data class BankResolved(val data: ResponseData.Finance.AccountData?) : SettingsStates()
//data class BvnResolved(val data: ResponseData.Finance.BVNData?) : SettingsStates()
//data class TerminalProvidersLoaded(val data: MutableList<ResponseData.Hardwares.HardwareProvider>?) : SettingsStates()
//data class POSTerminalsLoaded(val data: MutableList<TractionPOSTerminal>?) : SettingsStates()
object RoleCreated : SettingsStates()
object RoleDeleted : SettingsStates()
object AccountVerified : SettingsStates()
object CompanyInfoUpdated : SettingsStates()
object EmployeeCreated : SettingsStates()
object EmployeesFetched : SettingsStates()
object FetchingEmployees : SettingsStates()
object PaymentAccountUpdated : SettingsStates()
object FetchingPaymentAccounts : SettingsStates()
object InviteSent : SettingsStates()
object LoggedOut : SettingsStates()
object POSTerminalAdded : SettingsStates()
object POSTerminalUpdated : SettingsStates()
data class InviteFailed(val message: String="") : SettingsStates()
